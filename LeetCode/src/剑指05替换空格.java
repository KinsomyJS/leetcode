import java.util.ArrayList;
import java.util.List;

public class 剑指05替换空格 {
    public static String replaceSpace(String s) {
        List<String> list = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                list.add(s.substring(left, i));
                left = i + 1;
            }
        }
        if (left == s.length() - 1) {
            list.add(s.substring(left));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < list.size() - 1; j++) {
            stringBuilder.append(list.get(j));
            stringBuilder.append("%20");
        }
        stringBuilder.append(list.get(list.size() - 1));
        if (s.charAt(s.length() - 1) == ' ') {
            stringBuilder.append("%20");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        replaceSpace("     ");
    }
}
