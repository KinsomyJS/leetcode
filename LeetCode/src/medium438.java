import sun.security.util.PendingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium438 {
    public static List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        int len = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        boolean match = false;
        for (int i = 0; i < len - p.length() + 1; i++) {
            if (match) {
                if (s.substring(i - 1, i).equals(s.substring(i + pLen - 1, i + pLen))) {
                    res.add(i);
                    match = true;
                }else {
                    match = false;
                }
                continue;
            }
            char[] arr = s.substring(i, i + pLen).toCharArray();
            Arrays.sort(arr);
            if (Arrays.equals(pArr, arr)) {
                res.add(i);
                match = true;
                continue;
            }
            match = false;
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}
