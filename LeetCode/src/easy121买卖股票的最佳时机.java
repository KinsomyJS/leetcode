public class easy121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        if (len == 0) {
            return res;
        }
        int buy = prices[0];
        for (int i = 1; i < len; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
                continue;
            }
            res = Math.max(res, prices[i] - buy);
        }
        return res;
    }
}
