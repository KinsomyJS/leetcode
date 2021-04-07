public class easy206反转链表 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(head.val);
        res.next = null;
        head = head.next;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = res;
            res = temp;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        reverseList(head);
    }
}
