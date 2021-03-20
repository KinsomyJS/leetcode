import java.util.ArrayList;
import java.util.List;

public class medium144二叉树前序遍历 {

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
