public class 剑指55I二叉树的深度 {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }
        dfs(root, 1);
        return maxDepth;
    }

    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(depth, maxDepth);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
