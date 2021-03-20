import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class medium103二叉树的锯齿形层序遍历 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        bfs(list, true);
        return res;
    }

    private void bfs(List<TreeNode> list, boolean leftToRight) {
        if (list.size() == 0) {
            return;
        }
        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> child = new ArrayList<>();
        for (TreeNode node : list) {
            child.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        if (!leftToRight) {
            Collections.reverse(child);
        }
        res.add(child);
        bfs(nodes, !leftToRight);
    }
}
