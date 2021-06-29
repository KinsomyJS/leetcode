import java.util.HashMap;
import java.util.Map;

public class medium523连续的子数组和 {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int r = 0;
        for (int i = 0; i < len; i++) {
            r = (r + nums[i]) % k;
            if (map.containsKey(r)) {
                if (i - map.get(r) > 1) {
                    return true;
                }
            } else {
                map.put(r, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkSubarraySum(new int[]{3, 3}, 6);
    }
}
