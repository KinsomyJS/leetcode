public class medium75颜色分类 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int num0 = 0;
        int num1 = 0;
        for (int n : nums) {
            if (n == 0) {
                num0++;
            } else if (n == 1) {
                num1++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (i < num0) {
                nums[i] = 0;
            } else if (i < num0 + num1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
