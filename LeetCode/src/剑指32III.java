import java.util.*;

public class 剑指32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean reverse = false;
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            reverse = !reverse;
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> queueNew = new LinkedList<>();
            if (reverse) {
                for (TreeNode node : queue) {
                    list.add(node.val);
                    if (node.right != null) {
                        queueNew.add(node.right);
                    }
                    if (node.left != null) {
                        queueNew.add(node.left);
                    }
                }
            } else {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.removeLast();
                    if (node.left != null) {
                        queueNew.add(node.left);
                    }
                    if (node.right != null) {
                        queueNew.add(node.right);
                    }
                }
            }
            res.add(list);
            queue = queueNew;
        }

        return res;
    }
}
