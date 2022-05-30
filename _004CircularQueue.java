public class _004CircularQueue {
    // 队列的实现--基于数组（循环队列）
    public class CircularQueue {
        private String[] items;
        private int n;
        private int head = 0;
        private int tail = 0;

        public CircularQueue (int n) {
            this.items = new String[n];
            this.n = n;
        }

        public boolean enqueue (String item) {
            // tail 指向一个不存储数据的位置，当剩下一个位置时认为满，不然都用 head == tail 无法区分空和满
            if ((tail+1) % n == head) return false;
            items[tail] = item;
            tail = (tail+1) % n;// 涉及跨越最后一位和第一位的边界
            return true;
        }

        public String dequeue () {
            if (head == tail) return null;
            String ret = items[head];
            head = (head+1) % n;// 涉及跨越最后一位和第一位的边界
            return ret;
        }
    }
}
