import java.util.ArrayList;
import java.util.List;

public class medium54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int down = matrix.length - 1;
        if (down < 0) {
            return res;
        }
        int right = matrix[0].length - 1;
        int left = 0;
        int up = 0;
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            // 从上到下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            // 从右到左
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            // 从下到上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

}
