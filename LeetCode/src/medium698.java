import java.util.Arrays;

public class medium698 {
    int targetTotal;
    int length;
    int[] nums;
    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }
        targetTotal = total / k;
        length = nums.length;
        Arrays.sort(nums);
        if (nums[length - 1] > targetTotal) {
            return false;
        }
        this.nums = nums;
        dp = new boolean[1 << length];
        Arrays.fill(dp, true);
        return dfs((1 << length) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] + p > targetTotal) {
                break;
            }
            if (((s >> i) & 1) != 0) {
                if (dfs(s ^ (1 << i), (p + nums[i]) % targetTotal)) {
                    return true;
                }
            }
        }
        return false;
    }
}

