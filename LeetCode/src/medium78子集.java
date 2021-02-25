import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class medium78子集 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        res.add(new ArrayList<>());
        used = new boolean[length];
        for (int i = 1; i <= length; i++) {
            dfs(nums, length, used, 0, 0, i, new ArrayList<>());
        }
        return res;
    }

    private void dfs(int[] nums, int length, boolean[] used, int start, int depth, int k, List<Integer> path) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < length - (k - path.size()) + 1; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, length, used, i, depth + 1, k, path);
            used[i] = false;
            path.remove(depth);
        }
    }
}
