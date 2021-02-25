import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        dfs(len, 0, nums, new ArrayList<>(), used);
        return res;
    }

    private void dfs(int len, int depth, int[] nums, List<Integer> path, boolean[] used) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(len, depth + 1, nums, path, used);
            used[i] = false;
            path.remove(nums[i]);
        }
    }
}
