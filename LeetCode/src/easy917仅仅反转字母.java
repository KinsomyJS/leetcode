public class easy917仅仅反转字母 {
    public static String reverseOnlyLetters(String s) {
        int len = s.length();
        int x = 0;
        int y = len - 1;
        StringBuilder stringBuilder = new StringBuilder(s);
        while (x < y) {
            if (s.charAt(x) < 65 || (s.charAt(x) > 90 && s.charAt(x) < 97)) {
                x++;
                continue;
            }
            if (s.charAt(y) < 65 || (s.charAt(y) > 90 && s.charAt(y) < 97)) {
                y--;
                continue;
            }
            stringBuilder.replace(x, x + 1, String.valueOf(s.charAt(y)));
            stringBuilder.replace(y, y + 1, String.valueOf(s.charAt(x)));
            x++;
            y--;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        reverseOnlyLetters("Test1ng-Leet=code-Q!");
    }
}
