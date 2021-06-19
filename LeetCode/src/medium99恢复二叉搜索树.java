import java.util.ArrayList;
import java.util.List;

public class medium99恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        List<Integer> nodeVals = new ArrayList<>();
        inOrder(root, nodeVals);
        int i = -1;
        int j = -1;
        for (int idx = 0; idx < nodeVals.size() - 1; idx++) {
            if (nodeVals.get(idx) > nodeVals.get(idx + 1)) {
                j = nodeVals.get(idx + 1);
                if (i == -1) {
                    i = nodeVals.get(idx);
                } else {
                    break;
                }
            }
        }
        recover(root, 2, i, j);
    }

    private void inOrder(TreeNode root, List<Integer> nodeVals) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nodeVals);
        nodeVals.add(root.val);
        inOrder(root.right, nodeVals);
    }

    private void recover(TreeNode root, int count, int i, int j) {
        if (root != null) {
            if (root.val == i || root.val == j) {
                root.val = root.val == i ? j : i;
                if (--count == 0) {
                    return;
                }
            }

            recover(root.left, count, i, j);
            recover(root.right, count, i, j);
        }
    }
}
