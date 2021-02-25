/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */

public class medium64最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                    continue;
                }
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
