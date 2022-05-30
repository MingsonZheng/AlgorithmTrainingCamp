public class _004ArrayStack {
    public class ArrayStack {// 基于数组实现的顺序栈
        private int[] items;// 数组
        private int count;// 栈中元素个数
        private int n;// 栈的大小

        public ArrayStack (int n) {
            this.items = new int[n];// 申请一个大小为 n 的数组空间
            this.count = 0;
            this.n = n;
        }

        public boolean push (int item) {
            if (count == n) return false;// 数组空间不够，入栈失败
            // 将 item 放到下标为 count 的位置，并且 count 加 1
            items[count] = item;
            ++count;
            return true;
        }

        public int pop () {
            if (count == 0) return -1;// 栈为空，则直接返回 -1
            // 返回下标为 count-1 的数组元素，并且栈中元素个数 count 减一
            int value = items[count-1];
            --count;
            return value;
        }

        public int peek () {
            if (count == 0) return -1;// 栈为空，直接返回 -1
            return items[count-1];
        }
    }
}
