import jdk.nashorn.internal.runtime.RecompilableScriptFunctionData;

import java.util.ArrayList;
import java.util.List;

public class medium143重排链表 {
    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode root = head;
        while (root != null) {
            list.add(root);
            root = root.next;
        }
        int num = list.size();
        if (num <= 2) {
            return;
        }
        root = head;
        for (int i = 0; i < num / 2; i++) {
            ListNode temp = root.next;
            root.next = list.get(num - 1 - i);
            root = root.next;
            root.next = temp;
            root = root.next;
        }
        root.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        reorderList(node);
    }
}
