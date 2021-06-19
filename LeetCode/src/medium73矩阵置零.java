import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class medium73矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowZeroCounts = new int[m];
        int[] colZeroCounts = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rowZeroCounts[row] += 1;
                    colZeroCounts[col] += 1;
                }
            }
        }
        for (int row = 0; row < m; row++) {
            int count = 0;
            for (int col = 0; col < n; col++) {
                if (rowZeroCounts[row]>0 || colZeroCounts[col] > 0) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
