package _009BinaryTrees;

public class _009BinaryTrees_find {
    // 二叉查找树的查找操作
    // 2、非递归实现
    public Node find(Node root, int data){
        Node p = root;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 1、递归实现
    public Node find_r(Node root, int data) {
        if (root == null) return null;
        if (root.data == data) {
            return root;
        }
        if (data < root.data) {
            return find_r(root.left, data);
        } else {
            return find_r(root.right, data);
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
