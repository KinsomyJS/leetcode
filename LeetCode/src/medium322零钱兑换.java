import java.util.Arrays;

public class medium322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin == amount) {
                return 1;
            }
            if (coin < amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[amount] <= amount) {
            return dp[amount];
        }
        return -1;
    }
}
