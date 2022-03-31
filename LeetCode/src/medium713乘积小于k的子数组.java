import java.util.Arrays;

public class medium713乘积小于k的子数组 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{1, 1, 1, 1}, 1);
    }
}
