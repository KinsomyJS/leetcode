public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int res = 0;
        int nRow = grid.length;
        int nCol = grid[0].length;
        for (int r = 0; r < nRow; r++) {
            for (int c = 0; c < nCol; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        if (row < 0 || col < 0 || row >= nRow || col >= nCol || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
