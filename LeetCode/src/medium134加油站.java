public class medium134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int rest = 0;
            for (int j = i; j < i + len; j++) {
                int index = (j + len) % len;
                rest = rest + gas[index] - cost[index];
                if (rest < 0) {
                    i = index;
                    break;
                }
            }
            if (rest >= 0) {
                return i;
            }
        }
        return -1;
    }
}
