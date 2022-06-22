package _009BinaryTrees;

public class _009BinaryTrees_node {
    // 节点的定义
    // 基于指针的存储方式（大部分情况都用这种方式）
    public class Node {
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node root = null;
}
