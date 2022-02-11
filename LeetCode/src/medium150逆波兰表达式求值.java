import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class medium150逆波兰表达式求值 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int i2 = stack.pop();
                int i1 = stack.pop();
                int newI = 0;
                switch (t) {
                    case "+":
                        newI = i1 + i2;
                        break;
                    case "-":
                        newI = i1 - i2;
                        break;
                    case "*":
                        newI = i1 * i2;
                        break;
                    case "/":
                        newI = i1 / i2;
                        break;
                    default:
                        break;
                }
                stack.push(newI);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }
}
