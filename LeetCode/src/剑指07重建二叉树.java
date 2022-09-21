import java.util.HashMap;
import java.util.Map;

public class 剑指07重建二叉树 {
    Map<Integer, Integer> idxMap = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootIdx = idxMap.get(preorder[preLeft]);
        int leftSize = inRootIdx - inLeft;
        root.left = helper(preLeft + 1, preLeft + leftSize, inLeft, inRootIdx - 1);
        root.right = helper(preLeft + 1 + leftSize, preRight, inRootIdx + 1, inRight);
        return root;
    }
}
