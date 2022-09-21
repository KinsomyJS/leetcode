import com.sun.org.apache.bcel.internal.generic.NEW;

public class 剑指14剪绳子II {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static int minArray(int[] numbers) {
        int len = numbers.length;
        int[] newArr = new int[len * 2];
        for (int i = 0; i < len; i++) {
            newArr[i] = numbers[i];
        }
        for (int i = len; i < 2 * len; i++) {
            newArr[i] = numbers[i - len];
        }
        for (int i = 1; i < 2 * len - 1; i++) {
            if (newArr[i] < newArr[i - 1] && newArr[i] < newArr[i + 1]) {
                return newArr[i];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        minArray(new int[]{1, 3, 5});
    }
}
