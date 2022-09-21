import java.util.ArrayList;
import java.util.List;

public class 剑指68II {

    List<Integer> list = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p);
        List<Integer> pList = new ArrayList<>(list);
        list.clear();
        dfs(root, q);
        List<Integer> qList = new ArrayList<>(list);
        System.out.println(pList.toString());
        System.out.println(qList.toString());
        for (int i = pList.size() - 1;i >= 0;i --) {
            if(qList.contains(pList.get(i))){
                return new TreeNode(pList.get(i));
            }
        }
        return new TreeNode();
    }

    private void dfs(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == target.val) {
            return;
        }

        dfs(root.left, target);
        dfs(root.right, target);
        list.remove(list.size() - 1);
    }
}
