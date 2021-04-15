public class easy617合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode res = new TreeNode();
        dfs(res, root1, root2);
        return res;
    }

    private void dfs(TreeNode node, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (root1 == null) {
            node.val = root2.val;
            node.left = root2.left;
            node.right = root2.right;
            return;
        }
        if (root2 == null) {
            node.val = root1.val;
            node.left = root1.left;
            node.right = root1.right;
            return;
        }
        node.val = root1.val + root2.val;
        if (root1.left != null || root2.left != null) {
            node.left = new TreeNode();
        }
        if (root1.right != null || root2.right != null) {
            node.right = new TreeNode();
        }
        dfs(node.left, root1.left, root2.left);
        dfs(node.right, root1.right, root2.right);
    }
}
