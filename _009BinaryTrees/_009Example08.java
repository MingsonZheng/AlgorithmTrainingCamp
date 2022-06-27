package _009BinaryTrees;

// 题型 7：按照遍历结果反向构建二叉树
// 105. 从前序与中序遍历序列构造二叉树

public class _009Example08 {
    public static void main(String args[]){
        var preorder = new int[]{3, 9, 20, 15, 7};
        var inorder = new int[]{9, 3, 15, 20, 7};
        var root = buildTree(preorder, inorder);
        preOrder(root);
        inOrder(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    // preorder 下标 i, j; inorder 下标 p, q
    private static TreeNode myBuildTree(int[] preorder, int i, int j, int[] inorder, int p, int r) {
        if (i > j) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);
        // 在中序遍历结果 inorder 中，查询 preorder[i] 所在的位置 [p, split-1]split[split+1, q]
        int q = p;
        while (q <= r && inorder[q] != preorder[i]) {
            q++;
        }
        int leftTreeSIze = q - p;// 左右子树大小

        // 构建左子树
        TreeNode leftNode = myBuildTree(preorder, i+1, i+leftTreeSIze, inorder, p, q-1);
        // 构建右子树
        TreeNode rightNode = myBuildTree(preorder, i+leftTreeSIze+1, j, inorder, q+1, r);
        // 根据 root、左子树、右子树构建树
        root.left = leftNode;
        root.right = rightNode;
        return root;
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
