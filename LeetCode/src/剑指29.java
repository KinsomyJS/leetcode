public class 剑指29 {
    public static int[] spiralOrder(int[][] matrix) {
        int rowCount = matrix.length;
        if(rowCount == 0) {
            return new int[]{};
        }
        int colCount = matrix[0].length;
        int total = rowCount * colCount;
        int[] res = new int[rowCount * colCount];
        int x = 0;
        int y = 0;
        int idx = 0;

        while (idx < total) {
            // 遍历上边
            for (int i = y; i < colCount - y; i++) {
                res[idx] = matrix[x][i];
                idx++;
            }
            if (idx == total) {
                break;
            }
            // 遍历右边
            for (int i = x + 1; i < rowCount - x; i++) {
                res[idx] = matrix[i][colCount - y - 1];
                idx++;
            }
            if (idx == total) {
                break;
            }
            // 遍历下边
            for (int i = colCount - y - 2; i >= y; i--) {
                res[idx] = matrix[rowCount - x - 1][i];
                idx++;
            }
            if (idx == total) {
                break;
            }
            // 遍历左边
            for (int i = rowCount - x - 2; i >= x + 1; i--) {
                res[idx] = matrix[i][y];
                idx++;
            }
            if (idx == total) {
                break;
            }
            x++;
            y++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        spiralOrder(new int[][]{});
    }
}
