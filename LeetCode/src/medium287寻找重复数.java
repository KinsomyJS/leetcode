public class medium287寻找重复数 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int nums0Index = nums[0];
            if (nums[0] == nums[nums0Index]) {
                return nums[0];
            }
            int temp = nums[0];
            nums[0] = nums[nums0Index];
            nums[nums0Index] = temp;
        }
        return -1;
    }
}
