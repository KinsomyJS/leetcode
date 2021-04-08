import java.util.ArrayList;
import java.util.List;

public class easy234回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = nums.size() - 1; i < nums.size() / 2; i++, j--) {
            if (!nums.get(i).equals(nums.get(j))) {
                return false;
            }
        }
        return true;
    }
}
