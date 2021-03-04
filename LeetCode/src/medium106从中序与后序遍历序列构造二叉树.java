import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class medium106从中序与后序遍历序列构造二叉树 {
    int postIdx;
    int[] inorder;
    int[] postorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIdx = idx_map.get(rootVal);
        postIdx--;
        root.right = helper(inorderRootIdx + 1, inRight);
        root.left = helper(inLeft, inorderRootIdx - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postIdx = postorder.length - 1; // 后序最后一个为根节点
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }
}
