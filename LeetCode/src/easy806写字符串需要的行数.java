public class easy806写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 0;
        int chars = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (chars + width > 100) {
                lines++;
                chars = width;
            } else {
                chars += width;
            }
        }
        if (chars < 100) {
            lines--;
        } else {
            chars = 0;
        }
        return new int[]{lines, chars};
    }
}
