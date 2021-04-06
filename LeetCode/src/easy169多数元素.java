import java.util.Arrays;

public class easy169多数元素 {
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - target + 1;i++) {
            if(nums[i] == nums[i + target]) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
