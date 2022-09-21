import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 剑指49 {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        set.add(1l);
        priorityQueue.offer(1l);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = priorityQueue.poll();
            res = (int) cur;
            if (set.add(2 * cur)) {
                priorityQueue.offer(2 * cur);
            }
            if (set.add(3 * cur)) {
                priorityQueue.offer(3 * cur);
            }
            if (set.add(5 * cur)) {
                priorityQueue.offer(5 * cur);
            }
        }
        return res;
    }
}
