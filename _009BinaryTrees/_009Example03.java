package _009BinaryTrees;

// 104. 二叉树的最大深度

import java.util.Arrays;

public class _009Example03 {

    public static void main(String args[]) {
        var node15 = new TreeNode(15);
        var node7 = new TreeNode(7);
        var node20 = new TreeNode(20);
        node20.left = node15;
        node20.right = node7;
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = node20;
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
