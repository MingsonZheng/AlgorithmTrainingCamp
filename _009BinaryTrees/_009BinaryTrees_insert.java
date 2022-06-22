package _009BinaryTrees;

public class _009BinaryTrees_insert {
    // 二叉查找树的插入操作
    // 2、非递归实现
    public void insert2(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node p = root;
        while (p != null) {
            if(data > p.data) {
                if(p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if(p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    // 1、递归实现
    public void insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        insert_r(root, data);
    }

    public void insert_r(Node root, int data) {
        if (data > root.data) {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert_r(root.right, data);
            }
        } else {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert_r(root.left, data);
            }
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
