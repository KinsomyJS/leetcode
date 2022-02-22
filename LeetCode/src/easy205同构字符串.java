import java.util.HashMap;
import java.util.Map;

public class easy205同构字符串 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> tmap = new HashMap<>();
        Map<Character, Character> smap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if ((tmap.containsKey(s.charAt(i)) && tmap.get(s.charAt(i)) != t.charAt(i)) ||
                    (smap.containsKey(t.charAt(i)) && smap.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            }
            tmap.put(s.charAt(i), t.charAt(i));
            smap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("foo", "bar");
    }
}
