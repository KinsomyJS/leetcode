/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class medium328奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode oddTail = head; // 奇数尾部
        ListNode evenHead = head.next; // 偶数头部
        ListNode evenTail = evenHead; // 偶数尾部
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return head;
    }
}
