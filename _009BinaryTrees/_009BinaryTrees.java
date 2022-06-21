package _009BinaryTrees;

public class _009BinaryTrees {
    // 基于指针的存储方式（大部分情况都用这种方式）
    public class BinaryTree {
        // 节点的定义
        public class Node {
            public int data;
            public Node left;
            public Node right;
        }

        private  Node root = null;

        // 二叉树的遍历
        // 前序遍历：先打印根节点，然后再前序遍历左子树，最后再前序遍历右子树
        public void preOrder(Node root) {
            if (root == null) return;
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
