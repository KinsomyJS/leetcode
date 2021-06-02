import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class medium128最长连续序列 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }
            int currentNum = n;
            int total = 1;
            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                total++;
            }
            res = Math.max(res, total);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2};
        longestConsecutive(nums);
    }
}
