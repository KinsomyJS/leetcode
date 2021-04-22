import java.util.HashMap;
import java.util.Map;

public class medium560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int res = 0;
        map.put(0, 1);
        for (int i = 0; i < len; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
}
