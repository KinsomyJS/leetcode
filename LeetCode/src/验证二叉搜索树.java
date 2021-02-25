public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return bfs(root.left, root.val, null, true) && bfs(root.right, null, root.val, false);
    }

    private boolean bfs(TreeNode node, Integer max, Integer min, boolean left) {
        if (node == null) {
            return true;
        }
        if (left) {
            if (node.val >= max || (min != null && node.val <= min)) {
                return false;
            } else {
                return bfs(node.left, node.val, min, true) && bfs(node.right, max, node.val, false);
            }
        } else {
            if (node.val <= min || (max != null && node.val >= max)) {
                return false;
            } else {
                return bfs(node.left, node.val, min, true) && bfs(node.right, max, node.val, false);
            }
        }
    }
}
