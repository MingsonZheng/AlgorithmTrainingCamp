package _009BinaryTrees;

// 题型 4：二叉查找树
// 剑指 Offer 54. 二叉搜索树的第k大节点

public class _009Example05 {

    public static void main(String args[]) {
        var node2 = new TreeNode(2);
        var node1 = new TreeNode(1);
        node1.right = node2;
        var node4 = new TreeNode(4);
        TreeNode root = new TreeNode(3);
        root.left = node1;
        root.right = node4;
        System.out.println(kthLargest(root, 1));
    }

    static int count = 0;
    static int result;

    public static int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode root, int k) {
        if (count >= k) {// 提前终止递归，剪枝
            return;
        }
        if (root == null) {
            return;
        }
        inorder(root.right, k);
        count++;
        if (count == k) {
            result = root.val;
            return;// 提前终止递归，剪枝
        }
        inorder(root.left, k);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
