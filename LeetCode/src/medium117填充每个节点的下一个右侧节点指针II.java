import jdk.nashorn.internal.objects.NativeUint8Array;

public class medium117填充每个节点的下一个右侧节点指针II {
    public Node connect(Node root) {
        Node lastNode = null;
        Node nextStart = null;
        if (root == null) {
            return null;
        }
        Node startNode = root;
        while (startNode != null) {
            lastNode = null;
            nextStart = null;
            do {
                if (startNode.left != null) {
                    if (lastNode != null) {
                        lastNode.next = startNode.left;
                    }
                    if (nextStart == null) {
                        nextStart = startNode.left;
                    }
                    lastNode = startNode.left;
                }

                if (startNode.right != null) {
                    if (lastNode != null) {
                        lastNode.next = startNode.right;
                    }
                    if (nextStart == null) {
                        nextStart = startNode.right;
                    }
                    lastNode = startNode.right;
                }
                startNode = startNode.next;
            } while (startNode != null);
            startNode = nextStart;
        }

        return root;
    }
}
