import java.util.HashMap;
import java.util.Map;

public class medium137只出现一次的数字II {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                return (int) entry.getKey();
            }
        }
        return -1;
    }
}

