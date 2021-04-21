public class easy461汉明距离 {
    public int hammingDistance(int x, int y) {
        int XORInt = x ^ y;
        int res = 0;
        while (XORInt != 0) {
            res += XORInt % 2;
            XORInt /= 2;
        }
        return res;
    }
}
