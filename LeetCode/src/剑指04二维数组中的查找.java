public class 剑指04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < m) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                row--;
                continue;
            }
            if (matrix[row][col] < target) {
                col++;
            }
        }
        return false;
    }
}
