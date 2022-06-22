package _009BinaryTrees;

public class _009BinaryTrees_Order {
    // 二叉树的遍历
    // 前序遍历：先打印根节点，然后再前序遍历左子树，最后再前序遍历右子树
    public void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 中序遍历：先中序遍历左子树，然后打印根节点，最后再中序遍历右子树
    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    // 后序遍历：先后序遍历左子树，然后后续遍历右子树，最后打印根节点
    public void postOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.data);
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
