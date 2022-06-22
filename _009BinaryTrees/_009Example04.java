package _009BinaryTrees;

// 题型 4：二叉查找树
// 剑指 Offer 55 - II. 平衡二叉树

public class _009Example04 {

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
        System.out.println(isBalanced(root));
    }

    private static boolean balanced = true;

    public static boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (balanced == false) {// 提前终止递归
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
