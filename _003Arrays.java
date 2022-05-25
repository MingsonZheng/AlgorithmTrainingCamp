public class _003Arrays {
    // 动态扩容的数组
    public class MyArrayList {
        public int data[];
        private int n=10;
        private int count=0;

        public MyArrayList() {
            data = new int[n];
        }

        public void add (int element) {
            if (count == n) {
                int newData[] = new int[n*2];
                for (int i = 0; i < n; i++) {
                    newData[i] = data[i];
                }
                n *= 2;
                data = newData;
            }
            data[count] = element;
            count++;
        }
    }
}
