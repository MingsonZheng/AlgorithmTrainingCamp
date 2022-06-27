package _009BinaryTrees;

// 题型 6：二叉树转单、双、循环链表
// 114. 二叉树展开为链表
public class _009Example07 {
    public static void main(String args[]){
        var node3 = new TreeNode(3);
        var node4 = new TreeNode(4);
        var node2 = new TreeNode(2);
        node2.left = node3;
        node2.right = node4;
        var node6 = new TreeNode(6);
        var node5 = new TreeNode(5);
        node5.right = node6;
        var root = new TreeNode(1);
        root.left = node2;
        root.right = node5;
        flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    private static TreeNode dummyHead = new TreeNode();
    private static TreeNode tail = dummyHead;

    public static void flatten(TreeNode root) {
        preorder(root);
    }

    private static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        // 把遍历的节点放到结果链表中
        tail.right = root;
        tail = root;
        root.left = tail;

        // 左子树
        preorder(left);
        // 右子树
        preorder(right);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
