import java.util.Arrays;

public class medium518零钱兑换II {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;


        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return  dp[amount];
    }
}
