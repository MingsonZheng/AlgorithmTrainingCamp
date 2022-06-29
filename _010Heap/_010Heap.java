package _010Heap;

public class _010Heap {
    public class Heap{
        // 删除堆顶元素
        public void removeTop() {
            if (count == 0) {
                return;// 堆中没有数据
            }
            a[1] = a[count];
            --count;
            heapify(a, count, 1);
        }

        // 自上往下堆化
        private void heapify(int a[], int n, int i) {
            while(true) {
                int maxPos = i;
                if (i*2 <= n && a[i] < a[i*2]) {
                    maxPos = i*2;
                }
                if (i*2+1 <= n && a[maxPos] < a[i*2+1]) {
                    maxPos = i*2+1;
                }
                if (maxPos == i) {
                    break;
                }
                swap(a, i, maxPos);
                i = maxPos;
            }
        }

        // 取堆顶元素
        public int top() {
            if (count == 0) {
                return Integer.MIN_VALUE;
            }
            return a[1];
        }

        // 往堆中插入数据
        public void insert(int data) {
            if (count >= n) {
                return;// 堆满了
            }
            ++count;
            a[count] = data;
            int i = count;
            while (i/2 > 0 && a[i] > a[i/2]) {// 自上往下堆化
                swap(a, i, i/2);// swap() 函数作用：交换下标为 i 和 i/2 的两个元素
                i = i/2;
            }
        }

        // 交换下标为 i 和 i/2 的两个元素
        private void swap(int a[], int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private int a[];// 数组，从下标 1 开始存储数据
        private int n;// 堆可以存储的最大数据个数
        private int count;// 堆中已经存储的数据个数

        public Heap(int capacity) {
            a = new int[capacity+1];// 多申请一个空间，下标为 0 的位置不存储
            n = capacity;
            count = 0;
        }
    }
}
