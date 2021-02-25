import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class medium145二叉树的后序遍历 {
    /**
     * 迭代算法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }


    /**
     * 递归算法
     */
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurse(root,result);
        return result;
    }

    private void recurse(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        recurse(root.left,res);
        recurse(root.right,res);
        res.add(root.val);
    }*/


}
