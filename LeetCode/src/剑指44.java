public class 剑指44 {
    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        double sum = 10;
        double prevSum = 10;
        int num = 1;
        while (true) {
            num++;
            prevSum = sum;
            sum = sum + (Math.pow(10, num) - 1 - Math.pow(10, num - 1) + 1) * num;
            if (n < sum) {
                break;
            }
        }
        int rest = (int) (n - prevSum);
        int mod = rest % num;
        if (mod == 0) {
            mod = num - 1;
        } else {
            mod = mod - 1;
        }
        int left = (int) (Math.pow(10, num - 2) + rest / (Math.pow(10, num - 1) * num));
        int right = ((rest - 1) % (num * 10)) / num;
        String val = String.valueOf(left * 10 + right);
        return Integer.parseInt(val.substring(mod, mod + 1));
    }

    public static void main(String[] args) {
        findNthDigit(1000);
    }
}
