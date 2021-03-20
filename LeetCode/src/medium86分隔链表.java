import java.util.ArrayList;
import java.util.List;

public class medium86分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> small = new ArrayList<>();
        List<ListNode> large = new ArrayList<>();

        while (head != null) {
            if (head.val >= x) {
                large.add(head);
            } else {
                small.add(head);
            }
            head = head.next;
        }

        for (int i = 0; i < small.size() - 1; i++) {
            small.get(i).next = small.get(i + 1);
        }
        for (int j = 0; j < large.size() - 1; j++) {
            large.get(j).next = large.get(j + 1);
        }
        if (small.size() == 0) {
            large.get(large.size() - 1).next = null;
            return large.get(0);
        }

        if (large.size() == 0) {
            small.get(small.size() - 1).next = null;
            return small.get(0);
        }

        small.get(small.size()-1).next = large.get(0);
        large.get(large.size() - 1).next = null;
        return small.get(0);
    }
}
