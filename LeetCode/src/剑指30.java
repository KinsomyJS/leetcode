import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 剑指30 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public 剑指30() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
