public class _004LinkedListStack {
    public class LinkedListStack {// 基于链表的链式栈
        public class Node {
            public int data;
            public Node next;
            public Node (int data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
        private Node head = null;

        public void push (int value) {
            Node newNode = new Node(value, null);
            newNode.next = head;
            head = newNode;
        }

        public int pop () {
            if (head == null) return -1;
            int value = head.data;
            head = head.next;
            return value;
        }

        public int peek () {
            if (head == null) return -1;
            return head.data;
        }
    }
}
