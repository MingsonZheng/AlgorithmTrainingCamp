package _009BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题型 1：二叉树前中后序遍历
// 589. N 叉树的前序遍历

public class _009Example01 {

    public static void main(String[] args) {
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        List<Node> node3s = new ArrayList<>();
        node3s.add(node5);
        node3s.add(node6);
        Node node3 = new Node(3, node3s);
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        List<Node> nodes = new ArrayList<>();
        nodes.add(node3);
        nodes.add(node2);
        nodes.add(node4);
        Node root = new Node(1, nodes);
        preorder(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<Integer> result = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        preorder_r(root);
        return result;
    }

    private static void preorder_r(Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder_r(root.children.get(i));
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
