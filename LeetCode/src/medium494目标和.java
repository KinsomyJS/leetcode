public class medium494目标和 {
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, nums[0], 0);
        dfs(nums, target, -nums[0], 0);
        return res;
    }

    private void dfs(int[] nums, int target, int sum, int idx) {
        if (idx == nums.length - 1) {
            if (sum == target) {
                res++;
            }
            return;
        }
        idx++;
        dfs(nums, target, sum + nums[idx], idx);
        dfs(nums, target, sum - nums[idx], idx);
    }
}
