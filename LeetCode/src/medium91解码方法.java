public class medium91解码方法 {
    public static int numDecodings(String s) {
        int length = s.length();
        if (length == 0 || s.startsWith("0")) {
            return 0;
        }
        int dp[] = new int[length];
        char[] charArray = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        numDecodings("10");
    }
}
