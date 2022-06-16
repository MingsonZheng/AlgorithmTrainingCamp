package _003ArraysAndLinkedLists;

public class _003DoublyLinkedList {
    // 双向链表的定义
    public class Node {
        public int data;
        public Node prev;
        public Node next;
        public Node (int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node head = null;

    // 删除给定的节点
    public Node deleteThisNode (Node head, Node p) {
        if (p == null || head == null) {
            return null;
        }
        if (p == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
        return head;
    }
}
