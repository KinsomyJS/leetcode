import java.util.ArrayList;
import java.util.List;

public class medium109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int middle = list.size() / 2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = bfs(0, middle - 1, list);
        root.right = bfs(middle + 1, list.size() - 1, list);
        return root;
    }

    public TreeNode bfs(int left, int right, List<Integer> list) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = bfs(left, mid - 1, list);
        root.right = bfs(mid + 1, right, list);
        return root;
    }
}
