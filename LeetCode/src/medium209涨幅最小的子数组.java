public class medium209涨幅最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = 0;
        int len = nums.length;
        int x = 0;
        int y = 0;
        int sum = nums[x];
        while (x <= y && y < len) {
            if (sum >= target) {
                if (x == y) {
                    return 1;
                }
                if (res == 0) {
                    res = y - x + 1;
                } else {
                    res = Math.min(res, y - x + 1);
                }
                sum -= nums[x];
                x++;
            } else {
                y++;
                if (y < len) {
                    sum += nums[y];
                }
            }
        }
        return res;
    }
}
