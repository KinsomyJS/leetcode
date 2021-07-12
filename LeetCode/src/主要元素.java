public class 主要元素 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int res = -1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
                continue;
            }
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int j = 0;j < len;j++) {
            if(res == nums[j]) {
                count++;
            }
        }
        return count > len / 2 ? res : -1;
    }
}
