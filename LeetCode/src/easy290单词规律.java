import java.util.HashMap;

public class easy290单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> p2s = new HashMap<>();
        HashMap<String, Character> s2p = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Character c = pattern.charAt(i);
            if (p2s.containsKey(c) && s2p.containsKey(arr[i])) {
                if (p2s.get(c).equals(arr[i]) && s2p.get(arr[i]) == c) {
                    continue;
                } else {
                    return false;
                }
            } else if (p2s.containsKey(c) || s2p.containsKey(arr[i])) {
                return false;
            } else {
                p2s.put(c, arr[i]);
                s2p.put(arr[i], c);
            }
        }
        return true;
    }
}
