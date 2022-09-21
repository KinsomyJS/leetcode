public class 剑指47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                dp[r][c] = grid[r][c] + Math.max(dp[r - 1][c], dp[r][c - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
