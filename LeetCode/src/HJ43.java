import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ43 {

    static List<int[]> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int row = in.nextInt();
            int col = in.nextInt();

            int[][] maze = new int[row][col];
            int[][] visited = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = in.nextInt();
                }
            }
            List<int[]> steps = new ArrayList<>();
            steps.add(new int[]{0, 0});

            dfs(visited, maze, 0, 0, row - 1, col - 1, steps);
            for (int[] step : res) {
                System.out.println("(" + step[0] + "," + step[1] + ")");
            }
            return;
        }
    }

    private static void dfs(int[][] visited, int[][] maze, int r, int c, int row, int col, List<int[]> list) {
        if (r == row && c == col) {
            res = list;
            return;
        }
        if (r < row && maze[r + 1][c] == 0 && visited[r + 1][c] == 0) {
            visited[r + 1][c] = 1;
            List<int[]> newList = new ArrayList<>(list);
            newList.add(new int[]{r + 1, c});
            dfs(visited, maze, r + 1, c, row, col, newList);
        }

        if (r > 0 && maze[r - 1][c] == 0 && visited[r - 1][c] == 0) {
            visited[r - 1][c] = 1;
            List<int[]> newList = new ArrayList<>(list);
            newList.add(new int[]{r - 1, c});
            dfs(visited, maze, r - 1, c, row, col, newList);
        }
        if (c < col && maze[r][c + 1] == 0 && visited[r][c + 1] == 0) {
            visited[r][c + 1] = 1;
            List<int[]> newList = new ArrayList<>(list);
            newList.add(new int[]{r, c + 1});
            dfs(visited, maze, r, c + 1, row, col, newList);
        }

        if (c > 0 && maze[r][c - 1] == 0 && visited[r][c - 1] == 0) {
            visited[r][c - 1] = 1;
            List<int[]> newList = new ArrayList<>(list);
            newList.add(new int[]{r, c - 1});
            dfs(visited, maze, r, c - 1, row, col, newList);
        }

    }
}
//6 6
//        0 0 0 0 0 1
//        1 1 1 1 0 0
//        0 0 0 1 1 0
//        0 1 0 0 0 0
//        0 1 1 1 1 1
//        0 0 0 0 0 0