public class _003LinkedList {

    public static void main(String[] args) {
        // Java 语言中现成的链表实现：LinkedList（容器/工具类）
        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.addFirst(1);
        linkedList.add(2);
        linkedList.addLast(3);
        int val1 = linkedList.get(2);
        int val2 = linkedList.getFirst();
        int val3 = linkedList.getLast();
    }

    public class Node {
        public int data;
        public Node next;
        public Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head = null;

    // 遍历
    public void travel(Node head) {
        Node p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    // 查找
    public Node find(int value) {
        Node p = head; // p 用来遍历链表节点，初始化为 head
        while (p != null) { // 循环条件
            if (p.data == value) return p;
            p = p.next;
        }
        return null;
    }

    // 插入
    // 表头部插入，这种操作将与输入的顺序相反，逆序
    public void insertAtHead (int value) {
        Node newNode = new Node(value, null);
        newNode.next = head;
        head = newNode;
    }

    // 顺序插入，链表尾部插入
    public void insertAtTail (int value) {
        Node newNode = new Node(value, null);
        if (head == null) { // 优化 2
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) { // 优化 1
                p = p.next;
            }
            p.next = newNode;
        }
    }

    // 优化 1：添加 tail 指针
    private Node tail = null;// 记录链表尾节点的位置

    // 借助 tail 指针简化“往链表尾部插入节点”
    public void insertAtTail2 (int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    // 优化 2：引入虚拟头节点

    private Node head3 = new Node(0, null);
    private Node tail3 = head3;

    // 借助虚拟节点，以及 tail 指针，简化“往链表尾部插入节点”
    public void insertAtTail3 (int value) {
        Node newNode = new Node(value, null);
        tail3.next = newNode;
        tail3 = newNode;
    }

    // 在给定结点之后插入
    public void insertAfter (Node p, int value) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(value, null);
        newNode.next = p.next;
        p.next = newNode;
    }

    // 删除
    // 删除给定节点之后的节点
    public void deleteNextNode (Node p) {
        if (p == null || p.next == null) {
            return;
        }
        p.next = p.next.next;
    }

    // 删除给定的节点
    public Node deleteThisNode (Node head, Node p) {
        if (p == null || head == null) {
            return null;
        }
        Node prev = null;// 前驱节点
        Node q = head;
        while (q != null) { // 遍历查找 p
            if (q == p) {
                break;
            }
            prev = q;
            q = q.next;
        }
        if (q == null) return head; // 没有找到
        if (prev == null) { // 删除头节点
            head = head.next;
        } else { // 删除非头节点
            prev.next = prev.next.next;
        }
        return head;
    }

    // 优化：添加虚拟头节点
    public Node deleteThisNode2 (Node head, Node p) {
        if (p == null || head == null) {
            return null;
        }
        Node newHead = new Node(0, null);// 添加虚拟头节点
        newHead.next = head;
        Node prev = newHead;// 前驱节点
        Node q = head;
        while (q != null) { // 遍历查找 p
            if (q == p) {
                break;
            }
            prev = q;
            q = q.next;
        }
        if (q == null) return head; // 没有找到，返回虚拟头节点
        prev.next = prev.next.next;
        return newHead.next;
    }
}