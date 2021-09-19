import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class medium230二叉搜索树第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        while (true) {
            while (root != null) {
                deque.offer(root);
                root = root.left;
            }
            root = deque.pollLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

}
