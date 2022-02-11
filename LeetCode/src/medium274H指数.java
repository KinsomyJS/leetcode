public class medium274H指数 {
    public int hIndex(int[] citations) {
        int max = citations[0];
        for (int c : citations) {
            max = Math.max(max, c);
        }
        int[] counts = new int[max + 1];
        for (int c : citations) {
            counts[c] = counts[c] + 1;
        }
        int h = 0;
        int total = 0;
        for (int i = max; i >= 0; i--) {
            if (counts[i] > 0) {
                total += counts[i];
            }
            if (total >= i) {
                return i;
            }
        }
        if (counts.length == 1 || citations.length == counts[0]) {
            return 0;
        }
        return 1;
    }
}
