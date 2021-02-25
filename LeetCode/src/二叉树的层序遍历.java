import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 二叉树的层序遍历 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(Arrays.asList(root.val));
        List<TreeNode> nextNodes = new ArrayList<>();
        if (root.left != null) {
            nextNodes.add(root.left);
        }
        if (root.right != null) {
            nextNodes.add(root.right);
        }
        traverse(nextNodes);
        return res;
    }

    private void traverse(List<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        List<Integer> integers = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            integers.add(node.val);
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        res.add(integers);
        traverse(nextNodes);
    }
}
