public class 剑指25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        prev.next = null;
        ListNode res = new ListNode();
        res.next = prev;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                break;
            }
            if (l2 == null) {
                prev.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return res.next.next;
    }
}
