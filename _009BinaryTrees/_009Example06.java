package _009BinaryTrees;

// 题型 5：LCA 最近公共祖先
// 236. 二叉树的最近公共祖先

public class _009Example06 {
    public static void main(String args[]){
        var node7 = new TreeNode(7);
        var node4 = new TreeNode(4);
        var node2 = new TreeNode(2);
        node2.left = node7;
        node2.right = node4;
        var node6 = new TreeNode(6);
        var node5 = new TreeNode(5);
        node5.left = node6;
        node5.right = node2;
        var node0 = new TreeNode(0);
        var node8 = new TreeNode(8);
        var node1 = new TreeNode(1);
        node1.left = node0;
        node1.right = node8;
        var root = new TreeNode(3);
        root.left = node5;
        root.right = node1;
        var p = node5;
        var q = node1;
        var res = lowestCommonAncestor(root, p, q);
        if (res != null) {
            System.out.println(res.val);
        }
    }

    private static TreeNode lca = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    private static int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int leftContains = dfs(root.left, p, q);
        if (lca != null) {// 提前退出
            return 2;
        }
        int rightContains = dfs(root.right, p, q);
        if (lca != null) {// 提前退出
            return 2;
        }
        int rootContains = 0;
        if (root == p || root == q) {
            rootContains = 1;
        }
        if (rootContains == 0 && leftContains == 1 && rightContains == 1) {
            lca = root;
        }
        if (rootContains == 1 && (leftContains == 1 || rightContains == 1)) {
            lca = root;
        }
        return leftContains + rightContains + rootContains;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
