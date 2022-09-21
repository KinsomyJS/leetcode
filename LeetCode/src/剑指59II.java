import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 剑指59II {
    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();

    public 剑指59II() {

    }

    public int max_value() {
        if(queue.isEmpty()) {
            return  -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int res = queue.poll();
        if(deque.peekFirst() == res) {
            deque.pollFirst();
        }
        return res;
    }
}
