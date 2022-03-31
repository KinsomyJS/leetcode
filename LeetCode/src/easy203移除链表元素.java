public class easy203移除链表元素 {
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        while (root.next != null) {
            if (root.next.val != val) {
                root = root.next;
                continue;
            }
            root.next = root.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(7);
        removeElements(head, 7);
    }
}
