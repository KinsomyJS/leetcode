import java.util.ArrayList;
import java.util.List;

public class easy1380矩阵中的幸运数 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        for (int i = 0; i < rowNum; i++) {
            int minColIndx = 0;
            int minNum = matrix[i][0];
            for (int j = 1; j < colNum; j++) {
                if (matrix[i][j] < minNum) {
                    minNum = matrix[i][j];
                    minColIndx = j;
                }
            }
            int maxRowIdx = i;
            for (int k = 0; k < rowNum; k++) {
                if (minNum < matrix[k][minColIndx]) {
                    maxRowIdx = k;
                }
            }
            if (maxRowIdx == i) {
                res.add(matrix[maxRowIdx][minColIndx]);
            }
        }
        return res;
    }
}
