package _008HashTable;

// 基于位图（下标与数据一一映射）

public class _008Bitmap {
    // 假设存储数字范围为 0 ~ 63 的数据的位图：需要 64 个二进制位
    //boolean a[64]; 比较浪费时间
    //char a[4]; 每一个 char 包含 16 个二进制位，可以表示 16 个数据
    public class BitMap {// Java 中 char 类型占 16 bit，也即是 2 个字节
        private char[] a;
        private int nbits;

        public BitMap(int nbits) {
            this.nbits = nbits;
            this.a = new char[(nbits-1)/16+1];
        }

        public void set(int k) {
            if (k > nbits) return;
            int charIdx = k / 16;
            int bitIdx = k % 16;
            a[charIdx] |= (1 << bitIdx);
        }

        public boolean get(int k) {
            if (k > nbits) return false;
            int charIdx = k / 16;
            int bitIdx = k % 16;
            return (a[charIdx] & (1 << bitIdx)) !=0;
        }
    }

    // 顺序扫描数据集合，对于集合中的 x，我们标记：a[x] = true
    public class Mapping {
        private int maxValue = 300000000;
        private boolean a[] = new boolean[maxValue+1];

        public void add(int data) {
            a[data] = true;
        }

        public boolean contains(int data) {
            return a[data];
        }
    }
}
