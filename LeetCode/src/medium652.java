
import javafx.util.Pair;

import java.util.*;

public class medium652 {

    Map<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
    Set<TreeNode> repeat = new HashSet<>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int[] arr = {node.val, dfs(node.left), dfs(node.right)};
        String hash = Arrays.toString(arr);
        if (seen.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = seen.get(hash);
            repeat.add(pair.getKey());
            return pair.getValue();
        } else {
            seen.put(hash, new Pair<>(node, ++idx));
            return idx;
        }
    }

    private static int[] test(int[] a) {
        int[] newa = a;
        newa[0] = 3;
        return newa;
    }
    public static void main(String[] args) {
        int[] val = {0};
        System.out.println("1----"+Arrays.toString(val));
        int[] newVal = test(val);
        System.out.println("2----"+Arrays.toString(newVal));
        System.out.println("3----"+Arrays.toString(val));
    }
}
