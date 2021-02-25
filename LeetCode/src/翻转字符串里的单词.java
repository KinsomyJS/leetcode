import java.util.ArrayList;
import java.util.List;

public class 翻转字符串里的单词 {
    public static String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (word.length() != 0) {
                    list.add(word.toString());
                    word = new StringBuilder();
                }
                continue;
            }
            word.append(ch);
        }
        if (word.length() > 0) {
            list.add(word.toString());
        }
        StringBuilder res = new StringBuilder();
        if (list.size() > 0) {
            for (int j = list.size() - 1; j >= 0; j--) {
                res.append(list.get(j));
                res.append(" ");
            }
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        reverseWords("  the sky is blue  ");
    }
}
