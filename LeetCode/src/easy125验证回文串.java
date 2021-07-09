public class easy125验证回文串 {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int l = 0;
        int r = len - 1;
        s = s.toLowerCase();
        while (l <= r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            if (!isValidChar(lch)) {
                l++;
                continue;
            }
            if (!isValidChar(rch)) {
                r--;
                continue;
            }
            if (lch != rch) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return (48 <= c && c <= 57) || (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }
//
//    public static void main(String[] args) {
//        isPalindrome("A man, a plan, a canal: Panama");
//    }
}
