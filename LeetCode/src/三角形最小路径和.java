import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和 {
    private int sum = Integer.MIN_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        dfs(triangle, 1, 0, triangle.get(0).get(0));
        dfs(triangle, 1, 1, triangle.get(0).get(0));
        return sum;
    }

    private void dfs(List<List<Integer>> triangle, int depth, int broad, int num) {
        if (depth == triangle.size()) {
            if (sum == Integer.MIN_VALUE) {
                sum = num;
            } else {
                sum = Math.min(sum, num);
            }
            return;
        }
        if (broad > 0 && broad < depth ) {
            if (triangle.get(depth).get(broad) < triangle.get(depth).get(broad - 1)) {
                dfs(triangle, depth + 1, broad, num + triangle.get(depth).get(broad));
            }
            if (triangle.get(depth).get(broad) < triangle.get(depth).get(broad + 1)) {
                dfs(triangle, depth + 1, broad + 1, num + triangle.get(depth).get(broad));
            }
        } else {
            dfs(triangle, depth + 1, broad + 1, num + triangle.get(depth).get(broad));
            dfs(triangle, depth + 1, broad, num + triangle.get(depth).get(broad));
        }
    }
}
