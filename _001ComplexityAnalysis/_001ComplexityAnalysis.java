package _001ComplexityAnalysis;

public class _001ComplexityAnalysis {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.insert(1); // O(1)
        demo.insert(2); // O(1)
        // ...
        demo.insert(10); // O(1)
        demo.insert(11); // O(n) n = 10
        demo.insert(12); // O(1)
        // ...
        demo.insert(20); // O(1)
        demo.insert(21); // O(n) n = 20
        demo.insert(22); // O(1)
        // ...
        demo.insert(40); // O(1)
        demo.insert(41); // O(n) n = 40
        demo.insert(42); // O(1)
        // ...
    }

    // 反转数组
    public void reverse(int a[], int n){
        int tmp[] = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = a[n-i-1];
        }
        for (int i = 0; i < n; i++) {
            a[i] = tmp[i];
        }
    }

    // 反转数组
    public void reverse2(int a[], int n){
        for (int i = 0; i < n/2; i++) {
            int tmp = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = tmp;
        }
    }

    public static class Demo{
        private int n = 10;
        private int a[] = new int[n];
        private int count = 0;
        public void insert(int data){
            if (count == n){
                int b[] = new int[n * 2];
                for (int i = 0; i < n; i++) {
                    b[i] = a[i];
                }
                a = b;
                n = n * 2;
            }
            a[count] = data;
            count ++ ;
        }
    }

    public int search(int a[], int n, int target) {
        for (int i = 0; i < n; i++) { // ?次
            if (a[i] == target) { // ?次
                return i; // 1次
            }
        }
        return -1; // 1次
    }

    // 返回第一个比 n 大并且为 3 的 k 次方的数
    public int f4(int n) { // k1 * unit_time 1次
        int i = 1; // k2 * unit_time 1次
        while (i <= n){ // k3 * unit_time ?次
            i = i * 3; // k4 * unit_time ?次
        }
        return i; // // k5 * unit_time 1次
    }

    public int f2(int n) {
        int tmp = 0;
        for (int i = 1; i <= n; i++){
            tmp = tmp + 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++){
            result = result + i * tmp;
        }
        return result;
    }

    public int f(int n) {
        int result = 0; // k1 * unit_time 1次
        for (int i = 1; i <= n; i++){ // k2 * unit_time n次
            for (int j = 1; j <= n; ++j){ // k3 * unit_time n^2次
                result = result + i * j; // k4 * unit_time n^2次
            }
        }
        return result; // // k5 * unit_time 1次
    }

    public int sum(int n){
        int result = 0; // k1 * unit_time 1次
        for (int i = 1; i <= n; i++){ // k2 * unit_time n次
            result = result + i; // k3 * unit_time n次
        }
        return result; // // k4 * unit_time 1次
    }
}
