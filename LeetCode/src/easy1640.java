import java.util.Arrays;

public class easy1640 {
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int len = pieces.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (visited[j]) {
                    continue;
                }
                if (Arrays.equals(pieces[j], Arrays.copyOfRange(arr, i, i + pieces[j].length))) {
                    flag = true;
                    visited[j] = true;
                    i += pieces[j].length - 1;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canFormArray(new int[]{91,2,4,64,5,78,12,9},new int[][]{{78,12,3},{4,64,5},{91,2}});
    }
}
