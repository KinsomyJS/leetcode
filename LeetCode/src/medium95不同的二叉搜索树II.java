import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 */
public class medium95不同的二叉搜索树II {
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return res;
        }
        return recurse(1, n);
    }

    private List<TreeNode> recurse(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = recurse(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = recurse(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
