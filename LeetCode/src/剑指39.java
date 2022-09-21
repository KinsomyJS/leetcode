import java.util.HashMap;
import java.util.Map;

public class 剑指39 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            if (count > len / 2) {
                return nums[i];
            }
            map.put(nums[i], count);
        }
        return 0;
    }
}
