public class medium45跳跃游戏 {
    public static int jump(int[] nums) {
        int len = nums.length;
        boolean[] reached = new boolean[len];
        int target = len - 1;
        int res = 0;
        while (target > 0) {
            int index = target;
            for (int i = target - 1; i >= 0; i--) {
                if (target - i <= nums[i]) {
                    index = i;
                }
            }
            target = index;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
}
