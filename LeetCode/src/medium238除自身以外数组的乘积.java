public class medium238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] lArr = new int[len];
        lArr[0] = 1;
        int[] rArr = new int[len];
        rArr[len - 1] = 1;
        for (int i = 1, j = len - 2; i < len; j--, i++) {
            lArr[i] = lArr[i - 1] * nums[i - 1];
            rArr[j] = rArr[j + 1] * nums[j + 1];
        }
        for (int m = 0; m < len; m++) {
            nums[m] = lArr[m] * rArr[m];
        }
        return nums;
    }
}
