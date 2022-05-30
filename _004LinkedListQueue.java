public class _004LinkedListQueue {
    // 队列的实现--基于链表（链式队列）
    public class LinkedListQueue {
        public class Node {
            public String data;
            public Node next;
            public Node (String data, Node next) {
                this.data = data;
                this.next = next;
            }
        }
        private Node head = null;
        private Node tail = null;

        public void enqueue (String value) {
            Node newNode = new Node(value, null);
            if (tail == null) {// 空链表特殊处理
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }

        public String dequeue () {
            if (head == null) {
                return null;
            }
            String Value = head.data;
            head = head.next;
            if (head == null) {// 队列为空，tail 需要更新为 null
                tail = null;
            }
            return Value;
        }
    }
}
