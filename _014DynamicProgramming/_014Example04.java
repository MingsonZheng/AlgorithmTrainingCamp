package _014DynamicProgramming;

// 337. 打家劫舍 III

public class _014Example04 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node33 = new TreeNode(3);
        node2.right = node33;
        TreeNode node1 = new TreeNode(1);
        node3.right = node1;
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        int[] money = postorder(root);
        return Math.max(money[0], money[1]);
    }

    private static int[] postorder(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] leftMoney = postorder(root.left);
        int[] rightMoney = postorder(root.right);
        int[] money = new int[2];
        money[0] = Math.max(leftMoney[0], leftMoney[1]) + Math.max(rightMoney[0], rightMoney[1]);
        money[1] = (leftMoney[0] + rightMoney[0]) + root.val;
        return money;
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
