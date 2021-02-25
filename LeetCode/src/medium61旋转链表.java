public class medium61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        k = k % len;
        if (k == 0 || len == 1) {
            return head;
        }
        int index = 1;
        ListNode left = head;
        ListNode right = null;
        node = head;
        do {
            if (index == len - k) {
                right = node.next;
                head.next = null;
                break;
            }
            index++;
            node = node.next;
            head = head.next;
        } while (node.next != null);
        ListNode res = right;
        while (right.next != null) {
            right = right.next;
        }
        right.next = left;
        return res;
    }
}
