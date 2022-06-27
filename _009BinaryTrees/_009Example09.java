package _009BinaryTrees;

// 题型 8：二叉树上的最长路径和
// 剑指 Offer 34. 二叉树中和为某一值的路径

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _009Example09 {
    public static void main(String args[]){
        var node7 = new TreeNode(7);
        var node2 = new TreeNode(2);
        var node11 = new TreeNode(11, node7, node2);
        var node4 = new TreeNode(4, node11, null);
        var node5 = new TreeNode(5);
        var node1 = new TreeNode(1);
        var node44 = new TreeNode(4, node5, node1);
        var node13 = new TreeNode(13);
        var node8 = new TreeNode(8, node13, node44);
        var root = new TreeNode(5, node4, node8);
        var target = 22;
        var res = pathSum(root, target);
        System.out.println(Arrays.toString(res.toArray()));
    }

    private static List<List<Integer>> result;

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, sum, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs (TreeNode root, int sum, List<Integer> path, int pathSum) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (pathSum+root.val == sum) {
                List<Integer> pathSnapshot = new ArrayList<>();
                pathSnapshot.addAll(path);
                result.add(pathSnapshot);
            }
            path.remove(path.size()-1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, path, pathSum + root.val);
        }
        if (root.right != null) {
            dfs(root.right, sum, path, pathSum+root.val);
        }
        path.remove(path.size()-1);
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

    // 前序遍历：先打印根节点，然后再前序遍历左子树，最后再前序遍历右子树
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历：先中序遍历左子树，然后打印根节点，最后再中序遍历右子树
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
