import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */


public class medium47全排列Ⅱ {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {

        int length = nums.length;
        used = new boolean[length];
        Arrays.sort(nums);
        dfs(length, 0, nums, new ArrayList<>());
        return res;
    }

    private void dfs(int len, int depth, int[] nums, List<Integer> path) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(len, depth + 1, nums, path);
            used[i] = false;
            path.remove(depth);
        }
    }

//    public static void main(String[] args) {
//        permuteUnique(new int[]{2, 2, 1, 1});
//    }
}
