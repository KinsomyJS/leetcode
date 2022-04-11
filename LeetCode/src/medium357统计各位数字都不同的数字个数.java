public class medium357统计各位数字都不同的数字个数 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            int num = 9;
            for (int j = 1; j < i; j++) {
                num = num * (10 - j);
            }
            res += num;
        }
        return res;
    }
}
