import java.util.HashSet;
import java.util.Set;

public class 剑指II016 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int res = 0;
        int rightIdx = 0;
        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightIdx + 1 < len && !set.contains(s.charAt(rightIdx + 1))) {
                set.add(s.charAt(rightIdx + 1));
                ++rightIdx;
            }
            res = Math.max(res, rightIdx - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
}
