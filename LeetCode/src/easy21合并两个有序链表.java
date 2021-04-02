public class easy21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }
        return dummyNode.next;
    }
}
