import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class medium18四数之和 {
    static List<List<Integer>> res = new ArrayList<>();
    static boolean[] used;

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 4) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[length];
        dfs(length, 0, nums, new ArrayList<>(), 0, target, 0);
        return res;
    }

    private static void dfs(int len, int depth, int[] nums, List<Integer> path, int start, int target, int sum) {


        if(4 - depth + start > len) {
            return;
        }
        int minSum = sum;
        for (int i = 0; i < 4 - depth; i++) {
            minSum += nums[start + i];
        }

        if (minSum > target) {
            return;
        }


        if (depth == 4) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < len; i++) {
            if (used[i] || (i > start && nums[i] == nums[i - 1])) {
                continue;
            }

            sum += nums[i];
            used[i] = true;
            path.add(nums[i]);
            if (target > 0 && sum > target) {
                return;
            }

            dfs(len, depth + 1, nums, path, i + 1, target, sum);
            used[i] = false;
            sum -= path.get(depth);
            path.remove(depth);
        }
    }

    public static void main(String[] args) {
        fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }
}
