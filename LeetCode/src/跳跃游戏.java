public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] > 0) {
                continue;
            }
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > i - j) {
                    i = j;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
