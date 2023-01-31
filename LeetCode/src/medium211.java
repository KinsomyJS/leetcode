import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class medium211 {

    Map<Integer, Set<String>> map = new HashMap<>();

    public medium211() {

    }

    public void addWord(String word) {
        Set<String> set = map.getOrDefault(word.length(), new HashSet<>());
        set.add(word);
        map.put(word.length(), set);
    }

    public boolean search(String word) {
        Set<String> set = map.getOrDefault(word.length(), new HashSet<>());
        for (String str : set) {
            if (str.length() != word.length()) {
                continue;
            }
            if (str.equals(word)) {
                return true;
            }
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != str.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }
}
