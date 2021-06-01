import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class medium337打家劫舍III {
    private Map<TreeNode, Integer> sMap = new HashMap<>();
    private Map<TreeNode, Integer> nsMap = new HashMap<>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(sMap.getOrDefault(root, 0), nsMap.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        sMap.put(root, root.val + nsMap.getOrDefault(root.left, 0) + nsMap.getOrDefault(root.right, 0));
        nsMap.put(root,
                Math.max(nsMap.getOrDefault(root.left, 0), sMap.getOrDefault(root.left, 0)) +
                        Math.max(nsMap.getOrDefault(root.right, 0), sMap.getOrDefault(root.right, 0)));
    }
}
