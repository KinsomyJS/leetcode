import java.util.ArrayList;
import java.util.List;

public class 剑指06从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode root = head;
        while (root != null) {
            length++;
            root = root.next;
        }
        int[] res = new int[length];
        while (head != null) {
            length--;
            res[length] = head.val;
            head = head.next;
        }
        return res;
    }
}
