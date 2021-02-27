import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class medium31下一个排列 {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            }
            for (int k = length - 1; k >= i; k--) {
                if (nums[k] > nums[i - 1]) {
                    int tmp = nums[i - 1];
                    nums[i - 1] = nums[k];
                    nums[k] = tmp;
                    break;
                }
            }
            Arrays.sort(nums, i, nums.length);
            return;
        }
        Arrays.sort(nums);
    }
}
