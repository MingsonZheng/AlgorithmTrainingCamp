package _008HashTable;
import java.util.HashMap;
import java.util.Map;

// 例题 4：LRU 缓存（腾讯 CSIG 22 届暑期实习）

public class _008Example04 {

    class LRUCache {
        private class DLinkedNode {
            public int key;
            public int value;
            public DLinkedNode prev;
            public DLinkedNode next;
            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLinkedNode> hashtable = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.head = new DLinkedNode(-1, -1);// 虚拟节点
            this.tail = new DLinkedNode(-1, -1);// 虚拟节点
            this.head.prev = null;
            this.head.next = tail;
            this.tail.prev = head;
            this.tail.next = null;
        }

        public int get(int key) {// 1、在缓存中查找数据
            if (size == 0) {
                return -1;
            }
            DLinkedNode node = hashtable.get(key);
            if (node == null) {
                return -1;
            }
            removeNode(node);
            addNodeAtHead(node);
            return node.value;
        }

        public void remove(int key) {// 2、从缓存删除数据
            DLinkedNode node = hashtable.get(key);
            if (node != null) {
                removeNode(node);
                hashtable.remove(key);
                return;
            }
        }

        // 特殊情况：
        // 删除尾节点 -> 虚拟尾节点
        // 删除最后一个节点 -> 虚拟头节点
        private void removeNode(DLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void addNodeAtHead(DLinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        // 往缓存中添加一个数据
        public void put(int key, int value) {
            DLinkedNode node = hashtable.get(key);
            if (node != null) {
                node.value = value;
                removeNode(node);
                addNodeAtHead(node);
                return;
            }

            if (size == capacity) {
                hashtable.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
            DLinkedNode newNode = new DLinkedNode(key, value);
            addNodeAtHead(newNode);
            hashtable.put(key, newNode);
            size++;
        }
    }
}
