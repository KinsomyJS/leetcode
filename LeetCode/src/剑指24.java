import java.util.ArrayList;
import java.util.List;

public class 剑指24 {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode prev = new ListNode();
        ListNode res = prev;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode node = new ListNode(list.get(i));
            prev.next = node;
            prev = prev.next;
        }
        return res.next;
    }
}
