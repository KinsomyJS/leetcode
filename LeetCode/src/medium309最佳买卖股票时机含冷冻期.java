public class medium309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int profit0 = -prices[0];
        int profit1 = 0;
        int profit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newprofit0 = Math.max(profit0, profit2 - prices[i]);
            int newprofit1 = profit0 + prices[i];
            int newprofit2 = Math.max(profit1, profit2);
            profit0 = newprofit0;
            profit1 = newprofit1;
            profit2 = newprofit2;
        }
        return Math.max(profit1, profit2);
    }
}
