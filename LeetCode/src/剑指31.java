import java.util.Deque;
import java.util.LinkedList;

public class 剑指31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> pushStack = new LinkedList<>();
        int popIdx = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushStack.push(pushed[i]);
            if (popped[popIdx] == pushed[i]) {
                pushStack.pop();
                popIdx++;
            }
        }
        for (int i = popIdx; i < popped.length; i++) {
            if (pushStack.pop() != popped[i]) {
                return false;
            }
        }
        return pushStack.isEmpty();
    }
}
