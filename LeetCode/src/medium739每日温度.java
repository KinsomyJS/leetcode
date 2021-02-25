/*请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

        例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

        提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。*/

import java.util.Deque;
import java.util.LinkedList;

public class medium739每日温度 {
//    public int[] dailyTemperatures(int[] T) {
//        int num;
//        for (int i = 0; i < T.length; i++) {
//            num = 0;
//            for (int j = i + 1; j < T.length; j++) {
//                num++;
//                if (T[j] > T[i]) {
//                    break;
//                }
//                if (j == T.length - 1) {
//                    num = 0;
//                }
//            }
//            T[i] = num;
//        }
//        return T;
//    }

    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] res = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] >T[stack.peek()]) {
                int popIndex = stack.pop();
                res[popIndex] = i - popIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
