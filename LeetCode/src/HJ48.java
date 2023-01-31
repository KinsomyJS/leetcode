import java.util.LinkedList;
import java.util.Scanner;

public class HJ48 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int linkListSize = in.nextInt();
        int headVal = in.nextInt();
        ListNode head = new ListNode(headVal);
        ListNode prev = new ListNode();
        prev.next = head;

        for (int i = 0; i < linkListSize-1; i++) {
            int rightVal = in.nextInt();
            int leftVal = in.nextInt();
            ListNode root = prev.next;
            while (root != null) {
                if (root.val == leftVal) {
                    ListNode temp = root.next;
                    root.next = new ListNode(rightVal);
                    root.next.next = temp;
                    break;
                }
                root = root.next;
            }
        }

        int removeNodeVal = in.nextInt();
        ListNode start = prev.next;
        while (start != null) {
            if (start.val == removeNodeVal) {
                start = start.next;
                continue;
            }
            System.out.print(start.val + " ");
            start = start.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
