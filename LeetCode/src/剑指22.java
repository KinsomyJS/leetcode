public class 剑指22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prev = new ListNode();
        prev.next = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        if (len < k || prev.next == null) {
            return null;
        }
        int start = 0;
        while (start + k < len) {
            prev = prev.next;
            start++;
        }
        return prev.next;
    }
}
