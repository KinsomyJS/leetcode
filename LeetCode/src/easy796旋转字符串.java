public class easy796旋转字符串 {
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < len; i++) {
            sb.append(sb.substring(0, 1));
            sb.delete(0, 1);
            if (sb.toString().equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        rotateString("abcde","bcdea");
    }
}
