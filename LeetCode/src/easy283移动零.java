public class easy283移动零 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int point = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
