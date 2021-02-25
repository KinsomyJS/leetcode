import java.util.Arrays;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            res = Math.max(res, LIS[i]);
        }
        return res;
    }
}
