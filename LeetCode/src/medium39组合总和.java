import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class medium39组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0,0, candidates.length, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int depth, int start, int length, int target, int sum, List<Integer> path) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < length; i++) {
            sum += candidates[i];
            if(sum > target) {
                break;
            }
            path.add(candidates[i]);

            dfs(candidates, depth + 1,i, length, target, sum, path);

            sum -= path.get(depth);
            path.remove(depth);
        }
    }
}
