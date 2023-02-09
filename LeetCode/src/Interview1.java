/**
 * 伯索算法题：
 * 输入一个数字，通过交换其中的两位（最多交换一次，可以不交换），输出可以得到对应的最大值，如输入1234，交换1，4，得到4231
 * 实现对应的change方法
 */
public class Interview1 {

    public static int change(int num) {
        char[] inputArr = String.valueOf(num).toCharArray();
        char max = '0';
        int maxLastIdx = -1;
        int len = inputArr.length;
        for (int i = 0; i < len; i++) {
            max = '0';
            maxLastIdx = -1;
            for (int j = len - 1; j > i; j--) {
                if (inputArr[j] > inputArr[i] && inputArr[j] > max) {
                    max = inputArr[j];
                    maxLastIdx = j;
                }
            }
            if (maxLastIdx > 0) {
                inputArr[maxLastIdx] = inputArr[i];
                inputArr[i] = max;
                return Integer.parseInt(new String(inputArr));
            }
        }

        return num;
    }

    public static int change1(int num) {
        char[] inputArr = String.valueOf(num).toCharArray();
        int len = inputArr.length;
        char max = '0';
        int maxLastIdx = len -1;
        int leftChangeIdx = -1;
        int rightChangeIdx = -1;

        for (int i = len - 2;i >= 0;i--) {
            if(inputArr[i] > inputArr[maxLastIdx]) {
                maxLastIdx = i;
            } else if(inputArr[i] < inputArr[maxLastIdx]){
                leftChangeIdx = i;
                rightChangeIdx = maxLastIdx;
            }
        }

        if(leftChangeIdx > -1) {
            char temp = inputArr[rightChangeIdx];
            inputArr[rightChangeIdx] = inputArr[leftChangeIdx];
            inputArr[leftChangeIdx] = temp;
            return Integer.parseInt(new String(inputArr));
        }

        return num;
    }

    public static void main(String[] args) {
        int output = change1(2736);
        System.out.println(output);
    }
}
