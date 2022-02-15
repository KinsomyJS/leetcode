public class medium540有序数组中的单一元素 {
    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // [1,1,2,3,3,4,4,8,8]
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else  {
                return nums[mid];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1, 1, 2, 3, 3});
    }
}
