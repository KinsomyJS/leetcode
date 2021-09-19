import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class medium229求众数II {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int target = nums.length / 3;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > target) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
