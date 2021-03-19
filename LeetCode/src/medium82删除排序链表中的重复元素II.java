import java.util.ArrayList;
import java.util.List;

public class medium82删除排序链表中的重复元素II {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        List<ListNode> resList = new ArrayList<>();
        ListNode current = head;
        boolean duplicate = false;
        head = head.next;
        while (head != null) {
            if (current.val == head.val) {
                duplicate = true;
                head = head.next;
            } else {
                if (!duplicate) {
                    current.next = null;
                    resList.add(current);
                }
                current = head;
                head = head.next;
                duplicate = false;
            }
        }
        if (!duplicate) {
            resList.add(current);
        }
        if (resList.size() == 0) {
            return null;
        }

        for (int i = 0; i < resList.size() - 1; i++) {
            resList.get(i).next = resList.get(i + 1);
        }
        return resList.get(0);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        deleteDuplicates(l1);
    }
}
