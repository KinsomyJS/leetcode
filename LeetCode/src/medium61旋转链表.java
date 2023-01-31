import java.util.List;

public class medium61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode prev = new ListNode();
        ListNode temp = head;
        prev.next = temp;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        temp.next = head;

        temp = prev.next;

        for (int i = 0; i < len - k; i++) {
            temp = temp.next;
        }

        ListNode res = new ListNode();
        res.next = temp;

        for (int i = 0; i < len - 1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        return res.next;
    }
}

// 1 2 3 4 5 1 2 3 4 5