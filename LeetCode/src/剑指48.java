import java.util.HashSet;
import java.util.Set;

public class 剑指48 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int r = 0;
        int res = 1;
        for (int i = 0; i < len; i++) {
            if(i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            res = Math.max(res,set.size());
        }
        return res;
    }
}
