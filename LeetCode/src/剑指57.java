public class 剑指57 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{};
    }
}
