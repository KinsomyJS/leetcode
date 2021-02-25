public class 不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;
                    continue;
                }
                if (obstacleGrid[r - 1][c] == 1) {
                    dp[r - 1][c] = 0;
                }
                if (obstacleGrid[r][c - 1] == 1) {
                    dp[r][c - 1] = 0;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
