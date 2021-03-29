public class medium147对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode start = head.next;
        ListNode lastOrder = head;
        while (start != null) {
            if(lastOrder.val <= start.val) {
                start = start.next;
                lastOrder = lastOrder.next;
                continue;
            }
            ListNode temp = dummyNode;
            while (temp.next.val <= start.val ) {
                temp = temp.next;
            }

            lastOrder.next = start.next;
            start.next = temp.next;
            temp.next = start;
            start = lastOrder.next;
        }
        return dummyNode.next;
    }
}
