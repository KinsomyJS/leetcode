public class medium581最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int start = Integer.MAX_VALUE;
        int end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = Math.min(i - 1, start);
            }
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    end = i;
                    start = Math.min(j,start);
                    break;
                }
            }
        }
        if (end == -1) {
            return 0;
        }
        return end - start + 1;
    }
}
