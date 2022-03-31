import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class easy720词典中最长的单词 {
    public static String longestWord(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        int maxLen = 1;
        for (String word : words) {
            int len = word.length();
            maxLen = Math.max(maxLen, len);
            if (map.containsKey(len)) {
                map.get(len).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(len, list);
            }
        }


        for (int j = maxLen; j > 0; j--) {
            List<String> maxLenList = map.get(j);
            String res = "";
            if(maxLenList == null) {
                continue;
            }
            for (String w : maxLenList) {
                boolean flag = true;
                for (int i = 1; i < j; i++) {
                    if (!map.getOrDefault(i, new ArrayList<>()).contains(w.substring(0, i))) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    continue;
                }
                if (res.isEmpty()) {
                    res = w;
                } else {
                    res = res.compareTo(w) < 0 ? res : w;
                }
            }
            if(!res.isEmpty()) {
                return res;
            }
        }

        return "";
    }

    public static void main(String[] args) {
//        System.out.println("apply".compareTo("apple"));
        longestWord(new String[]{"l","le","lel","lelelele"});
    }
}
