import java.util.ArrayDeque;
import java.util.Deque;

public class easy1475 {
    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if(prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
