import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        bfs(queue);
        return res;
    }

    private void bfs(Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> childQueue = new LinkedList<>();
        int val = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            val = node.val;
            if (node.left != null) {
                childQueue.add(node.left);
            }
            if (node.right != null) {
                childQueue.add(node.right);
            }
        }
        res.add(val);
        bfs(childQueue);
    }
}
