public class 剑指21 {
    public static int[] exchange(int[] nums) {
        int len = nums.length;
        int x = 0;
        int y = len - 1;
        while (x < y) {
            if (nums[x] % 2 == 1) {
                x++;
            } else if (nums[y] % 2 == 0) {
                y--;
            } else if (nums[x] % 2 == 0 && nums[y] % 2 == 1) {
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
                x++;
                y--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        exchange(new int[]{1, 2, 3, 4, 5});
    }
}
