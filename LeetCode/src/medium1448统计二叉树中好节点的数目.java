public class medium1448统计二叉树中好节点的数目 {
    int res = 1;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            int leftVal = root.left.val;
            if (max <= leftVal) {
                res++;
                dfs(root.left, leftVal);
            } else {
                dfs(root.left, max);
            }
        }
        if (root.right != null) {
            int leftVal = root.right.val;
            if (max <= leftVal) {
                res++;
                dfs(root.right, leftVal);
            } else {
                dfs(root.right, max);
            }
        }
    }
}
