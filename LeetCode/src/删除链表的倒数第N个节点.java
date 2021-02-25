import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode zeroNode = new ListNode(-1);
        zeroNode.next = head;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        length -= n;
        temp = zeroNode;
        while (length > 0) {
            length--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return zeroNode.next;
    }
}
