public class 剑指18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode start = root;
        while (start.next != null) {
            if (start.next.val == val) {
                start.next = start.next.next;
                break;
            }
            start = start.next;
        }
        return root.next;
    }
}
