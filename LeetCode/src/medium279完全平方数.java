public class medium279完全平方数 {
    public static int numSquares(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int m = (int) Math.floor(Math.sqrt(i));
            if (m * m == i) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= m; j++) {
                min = Math.min(dp[j * j] + dp[i - j * j], min);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares(12);
    }
}
