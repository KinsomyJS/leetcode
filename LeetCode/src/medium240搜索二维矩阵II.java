import java.rmi.MarshalException;

public class medium240搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            }
        }
        return false;
    }
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        if (matrix[row][col] > target) {
            return false;
        }
        int x = Math.min(m, n);
        for (int i = 0; i < x; i++) {
            if (matrix[i][i] == target) {
                return true;
            }
            if (matrix[i][i] > target) {
                row = i;
                col = i;
                break;
            }
        }
        if(row == 0) {
            row = col = x;
        }
        for (int r = row; r < m; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == target) {
                    return true;
                }
            }
        }

        for (int c = col; c < n; c++) {
            for (int r = 0; r < row; r++) {
                if (matrix[r][c] == target) {
                    return true;
                }
            }
        }
        return false;

    }*/

}
