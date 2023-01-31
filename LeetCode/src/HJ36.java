import java.util.*;

public class HJ36 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();
        String content = in.nextLine();

        List<Character> keyList = new ArrayList<>();
        for (char c : key.toCharArray()) {
            if (keyList.contains(c)) {
                continue;
            }
            keyList.add(c);
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (keyList.contains(c)) {
                continue;
            }
            keyList.add(c);
        }

        StringBuilder res = new StringBuilder();
        for (char conChar : content.toCharArray()) {
            if (conChar >= 'a' && conChar <= 'z') {
                res.append(keyList.get(conChar - 'a'));
            } else {

            }
        }
        System.out.println(res);
    }
}
