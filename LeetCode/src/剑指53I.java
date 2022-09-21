public class 剑指53I {
    public int search(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (num == target) {
                res++;
            }
            if (num > target) {
                break;
            }
        }
        return res;
    }
}
