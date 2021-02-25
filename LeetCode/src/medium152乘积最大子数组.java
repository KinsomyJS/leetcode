public class medium152乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                arr[j] = arr[j - 1] * nums[j];
                if (arr[j] > max) {
                    max = arr[j];
                }
                if(arr[j] == 0) {
                    break;
                }
            }
        }
        return max;
    }
}
