package _009BinaryTrees;

// 剑指 Offer 32 - I. 从上到下打印二叉树

import com.sun.source.tree.Tree;

import java.util.*;

public class _009Example02 {

    public static void main(String args[]) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20);
        node20.left = node15;
        node20.right = node7;
        TreeNode node9 = new TreeNode(9);
        TreeNode root = new TreeNode(3);
        root.left = node9;
        root.right = node20;
        var result = levelOrder(root);
        System.out.println(Arrays.toString(result));
    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
