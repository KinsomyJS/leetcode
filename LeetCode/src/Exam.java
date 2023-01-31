import java.util.*;

public class Exam {
    //    static List<Integer> res = new ArrayList<>();
//    static int signalX = -1;
//    static int signalY = -1;
//
//    static int row = -1;
//    static int col = -1;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        row = in.nextInt();
//        col = in.nextInt();
//        int[][] arr = new int[row][col];
//
//        for (int r = 0; r < row; r++) {
//            for (int c = 0; c < col; c++) {
//                arr[r][c] = in.nextInt();
//                if (arr[r][c] > 0) {
//                    signalX = r;
//                    signalY = c;
//                }
//            }
//        }
//
//        boolean[][] visited = new boolean[row][col];
//
//        int i = in.nextInt();
//        int j = in.nextInt();
//
//        bfs(arr, i, j, visited, 1);
//
//        Collections.sort(res);
//        if (res.size() == 0) {
//            System.out.println(0);
//        } else if (arr[signalX][signalY] - res.get(0) < 0) {
//            System.out.println(0);
//        } else {
//            System.out.println(0);
//        }
//    }
//
//    public static void bfs(int[][] arr, int x, int y, boolean[][] visited, int steps) {
//        if (x == signalX && y == signalY) {
//            res.add(steps);
//            return;
//        }
//        if (arr[x][y] == -1) {
//            return;
//        }
//        if (x + 1 < row && !visited[x + 1][y]) {
//            visited[x + 1][y] = true;
//            bfs(arr, x + 1, y, visited, steps + 1);
//            visited[x + 1][y] = false;
//        }
//        if (y - 1 >= 0 && !visited[x][y - 1]) {
//            visited[x][y - 1] = true;
//            bfs(arr, x, y - 1, visited, steps + 1);
//            visited[x][y - 1] = false;
//        }
//        if (x - 1 >= 0 && !visited[x - 1][y]) {
//            visited[x - 1][y] = true;
//            bfs(arr, x - 1, y, visited, steps + 1);
//            visited[x - 1][y] = false;
//        }
//        if (y + 1 < col && !visited[x][y + 1]) {
//            visited[x][y + 1] = true;
//            bfs(arr, x, y + 1, visited, steps + 1);
//            visited[x][y + 1] = false;
//        }
//
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        采样人员数
        int nurseCount = in.nextInt();
//        志愿者数
        int volCount = in.nextInt();

        List<Integer> effList = new ArrayList<>();
        for (int i = 0; i < nurseCount; i++) {
            effList.add(in.nextInt());
        }
        Collections.sort(effList);
        System.out.println(effList);
        int idx = effList.size() - 1;
        if(nurseCount != volCount) {
            for (int i = idx; i >= 0; i--) {

                int eff = effList.get(idx);
                if (volCount > 4) {
                    volCount -= 4;
                    effList.set(idx, (int) (eff * 1.3));
                } else if (volCount == 3) {
                    volCount -= 3;
                    effList.set(idx, (int) (eff * 1.2));
                } else if (volCount == 2) {
                    volCount -= 2;
                    effList.set(idx, (int) (eff * 1.1));
                } else if (volCount == 1) {
                    volCount -= 1;
                } else {
                    effList.set(idx, (int) (eff * 0.8));
                }
            }
        }


        int total = 0;
        for (int eff : effList) {
            total += eff;
        }
        System.out.println(total);
    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String input = in.nextLine();
//        String[] inputArr = input.split(" ");
//        int[] count = new int[14];
//        Arrays.fill(count, 0);
//
//        for (String s : inputArr) {
//            count[Integer.parseInt(s)]++;
//        }
//        StringBuilder sb = new StringBuilder();
//        // 找炸弹
//        for (int i = 1; i <= 13; i++) {
//            if (count[i] < 4) {
//                continue;
//            }
//            int bombi = count[i] * i;
//            int maxIdx = i;
//            int maxBomb = bombi;
//            for (int j = i + 1; j < 14; j++) {
//                if (count[j] < 4) {
//                    continue;
//                }
//                int bombj = count[j] * j;
//                if (bombj > maxBomb) {
//                    maxIdx = j;
//                    maxBomb = bombj;
//                }
//            }
//            for (int k = 0; k < count[maxIdx]; k++) {
//                sb.append(maxIdx).append(" ");
//            }
//            count[maxIdx] = 0;
//            if (maxIdx != i) {
//                i--;
//            }
//        }
//
//        // 找葫芦
//        for (int i = 13; i > 0; i--) {
//            if (count[i] != 3) {
//                continue;
//            }
//            for (int j = i - 1; j > 0; j--) {
//                if (count[j] > 1) {
//                    for (int m = 0; m < 3; m++) {
//                        sb.append(i).append(" ");
//                    }
//                    count[i] = 0;
//                    for (int n = 0; n < 2; n++) {
//                        sb.append(j).append(" ");
//                    }
//                    count[j] = count[j] - 2;
//                    break;
//                }
//            }
//        }
//
//        // 找三张
//        for (int i = 13; i > 0; i--) {
//            if (count[i] != 3) {
//                continue;
//            }
//            for (int m = 0; m < 3; m++) {
//                sb.append(i).append(" ");
//            }
//            count[i] = 0;
//        }
//
//        // 找对子
//        for (int i = 13; i > 0; i--) {
//            if (count[i] != 2) {
//                continue;
//            }
//            for (int m = 0; m < 2; m++) {
//                sb.append(i).append(" ");
//            }
//            count[i] = 0;
//        }
//
//        // 找对子
//        for (int i = 13; i > 0; i--) {
//            if (count[i] != 1) {
//                continue;
//            }
//            sb.append(i).append(" ");
//            count[i] = 0;
//        }
//
//        System.out.println(sb);
//    }
}
