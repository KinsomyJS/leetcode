import java.util.Comparator;
import java.util.PriorityQueue;

public class 剑指40 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    public static void main(String[] args) {
        getLeastNumbers(new int[]{3, 2, 1}, 2);
    }
}
