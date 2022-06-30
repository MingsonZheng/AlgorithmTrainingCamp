package _011StringMatching;

public class _011StringMatching {

    public static void main(String[] args) {
        char a[] = new char[]{'a', 'b', 'd', 'c', 'a', 'c'};
        int n = a.length;
        char b[] = new char[]{'d', 'c', 'a'};
        int m = b.length;
        // BF 算法，暴力匹配算法、朴素字符串匹配算法
        System.out.println(bf(a, n, b, m));
    }

    // BF 算法，暴力匹配算法、朴素字符串匹配算法
    private static int bf(char a[], int n, char b[], int m) {
        for (int i = 0; i <= n-m; i++) {
            int j = 0;
            while (j < m) {
                if (a[i+j] != b[j]) {
                    break;
                }
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return 1;
    }
}
