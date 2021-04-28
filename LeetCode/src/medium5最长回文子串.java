public class medium5最长回文子串 {
    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            int length = 0;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                if (left == right) {
                    length++;
                } else {
                    length += 2;
                }
                left--;
                right++;
            }
            if (length > maxLen) {
                maxLen = length;
                l = left + 1;
                r = right - 1;
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        longestPalindrome("cbbd");
    }
}
