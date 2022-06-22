package _009BinaryTrees;

public class _009BinaryTrees_delete {
    // 二叉查找树的删除操作
    public void delete(int data) {
        Node p = root;// p 指向要删除的节点，初始化指向根节点
        Node pp = null;// pp 记录的是 p 的父节点
        while (p != null && p.data != data) {// 查找要删除的节点及其父节点
            pp = p;
            if (data > p.data){
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) return;// 没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {// 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p;// minPP 表示 minP 的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;// 将 minP 的数据替换到 p 中
            p = minP;// 下面就变成了删除 minP 了
            pp = minPP;
        }

        // 要删除的节点是叶子节点或者仅有一个子节点
        Node child = null;// 查找待删除节点 p 的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }
        if (pp == null) {
            root = child;// 删除的是根节点
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    // 节点的定义
    // 基于指针的存储方式（大部分情况都用这种方式）
    public class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node root = null;
}
