import java.util.ArrayList;
import java.util.List;

public class medium144二叉树前序遍历 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }

    public void recursion(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

}
