public class medium162寻找峰值 {
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int mid = (right + left) / 2 + (right + left) % 2;
            if (nums[mid] > nums[mid - 1]) {
                if (mid + 1 > right || nums[mid + 1] < nums[mid]) {
                    return mid;
                } else {
                    left = mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
    }
}
