import java.util.TreeSet;

public class medium220存在重复元素III {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int b = -2147483648;
        System.out.println(Math.abs((double) a - (double) b));
        containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
    }
}
