import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 剑指32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queueNew = new LinkedList<>();
            for (TreeNode node : queue) {
                list.add(node.val);
                if (node.left != null) {
                    queueNew.add(node.left);
                }
                if (node.right != null) {
                    queueNew.add(node.right);
                }
            }
            res.add(list);
            queue = queueNew;
        }

        return res;
    }
}
