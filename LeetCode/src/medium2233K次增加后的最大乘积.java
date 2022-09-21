import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class medium2233K次增加后的最大乘积 {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }
        while (k > 0) {
            pq.offer(pq.poll() + 1);
            k--;
        }
        long res = 1;
        for (int i : pq) {
            res = (res * i) % 1000000007l;
        }
        return (int) res;
    }
}
