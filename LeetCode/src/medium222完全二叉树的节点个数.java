import java.util.LinkedList;
import java.util.Queue;

public class medium222完全二叉树的节点个数 {
    /*public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res++;
            if (node.left == null) {
                break;
            } else {
                queue.offer(node.left);
            }
            if (node.right == null) {
                break;
            } else {
                queue.offer(node.right);
            }
        }
        return res + queue.size();
    }*/

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left);
        }else{
            return countNodes(root.left) + (1<<right);
        }
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}
