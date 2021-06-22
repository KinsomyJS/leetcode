import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class medium116填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);
        bfs(list);
        return root;
    }

    private void bfs(List<Node> list) {
        if (list.isEmpty()) {
            return;
        }
        List<Node> childList = new ArrayList<>();
        int length = list.size();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
            if (list.get(i).left != null) {
                childList.add(list.get(i).left);
                childList.add(list.get(i).right);
            }
        }
        bfs(childList);
    }
}
