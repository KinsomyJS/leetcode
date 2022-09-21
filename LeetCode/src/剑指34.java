import java.util.ArrayList;
import java.util.List;

public class 剑指34 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path, 0, target);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> path, int sum, int target) {
        if (node == null) {
            return;
        }
        sum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && sum == target) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, path, sum, target);
        dfs(node.right, path, sum, target);
        path.remove(path.size() - 1);
    }
}
