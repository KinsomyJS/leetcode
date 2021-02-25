import java.util.Arrays;

public class medium79单次搜索 {

    int row;
    int col;
    int len;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        len = word.length();
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (search(r, c, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(int r, int c, char[][] board, String word, int index, boolean[][] visited) {
        if (board[r][c] != word.charAt(index)) {
            return false;
        } else if (len - 1 == index) {
            return true;
        }
        visited[r][c] = true;
        boolean flag = false;
        if (r + 1 < row && board[r + 1][c] == word.charAt(index + 1) && !visited[r + 1][c]) {
            if (search(r + 1, c, board, word, index + 1, visited)) {
                return true;
            }
        }
        if (r - 1 >= 0 && board[r - 1][c] == word.charAt(index + 1) && !visited[r - 1][c]) {
            if (search(r - 1, c, board, word, index + 1, visited)) {
                return true;
            }
        }
        if (c + 1 < col && board[r][c + 1] == word.charAt(index + 1) && !visited[r][c + 1]) {
            if (search(r, c + 1, board, word, index + 1, visited)) {
                return true;
            }
        }
        if (c - 1 >= 0 && board[r][c - 1] == word.charAt(index + 1) && !visited[r][c - 1]) {
            if (search(r, c - 1, board, word, index + 1, visited)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }

//    public static void main(String[] args) {
//        exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
//    }
}
