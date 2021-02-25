import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class medium77组合 {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return res;
        }
        used = new boolean[n];
        dfs(n, used, 0, 0, k, new ArrayList<>());
        return res;
    }

    private void dfs(int n, boolean[] used, int start, int depth, int k, List<Integer> path) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < n - (k - path.size()) + 1; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(i + 1);
            dfs(n, used, i, depth + 1, k, path);
            used[i] = false;
            path.remove(depth);
        }
    }
}
