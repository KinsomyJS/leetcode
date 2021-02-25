public class medium343整数拆分 {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= i / 2; j--) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * Math.max(dp[i - j], i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}
