import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class medium92反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 0;
        ListNode root = new ListNode(-1);
        ListNode root2 = new ListNode(-2);
        root.next = head;
        root2.next = root;
        ListNode previousStart = new ListNode();
        ListNode leftStart = new ListNode();
        while (root.next != null) {
            if (index + 1 < left) {
                root = root.next;
                index++;
            } else if (index + 1 == left) {
                previousStart = root;
                leftStart = root.next;
                root = root.next;
                index++;
            } else if (index + 1 <= right) {
                ListNode tmp = root.next;
                root.next = root.next.next;
                previousStart.next = tmp;
                tmp.next = leftStart;
                leftStart = tmp;
                index++;
            } else {
                break;
            }
        }
        return root2.next.next;
    }
}