public class medium221 {

//     [       ["1","0","1","0","0"],
//             ["1","0","1","1","1"],
//             ["1","1","1","1","1"],
//             ["1","0","0","1","0"]]

    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                    }
                    maxSide = Math.max(dp[r][c], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        maximalSquare(matrix);
    }
}
