public class medium130被围绕的区域 {
    int row;
    int col;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'A';
                dfs(board, 1, i);
            }
            if (board[row - 1][i] == 'O') {
                board[row - 1][i] = 'A';
                dfs(board, row - 2, i);
            }
        }
        for (int j = 0; j < row; j++) {
            if (board[j][0] == 'O') {
                board[j][0] = 'A';
                dfs(board, j, 1);
            }
            if (board[j][col - 1] == 'O') {
                board[j][col - 1] = 'A';
                dfs(board, j, col - 2);
            }
        }
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if(board[m][n] == 'O') {
                    board[m][n] = 'X';
                }
                if(board[m][n] == 'A') {
                    board[m][n] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r > row - 2 || r < 1 || c > col - 2 || c < 1) {
            return;
        }
        if (board[r][c] == 'O' && (board[r - 1][c] == 'A' || board[r + 1][c] == 'A' || board[r][c - 1] == 'A' || board[r][c + 1] == 'A')) {
            board[r][c] = 'A';
            dfs(board, r - 1, c);
            dfs(board, r + 1, c);
            dfs(board, r, c - 1);
            dfs(board, r, c + 1);
        }
    }
}
