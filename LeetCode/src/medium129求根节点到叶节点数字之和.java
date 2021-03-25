public class medium129求根节点到叶节点数字之和 {

    public int sumNumbers(TreeNode root) {
        return dfs(0, root);
    }

    private int dfs(int sum, TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(sum, root.left) + dfs(sum, root.right);
    }
}
