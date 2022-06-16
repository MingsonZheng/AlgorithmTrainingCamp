package _005RecursionAndPartition;

public class _005RecursionAndPartition {
    // 备忘录
    private int[] mem;
    public int f4(int n) {
        mem = new int[n+1];
        return f_r(n);
    }

    public int f_r(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] != 0) return mem[n];
        mem[n] = f_r(n-1) + f_r(n-2);
        return mem[n];
    }

    // 递归函数
    public int f3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f3(n-1) + f3(n-2);
    }

    // 函数调用栈
    public int f2(int a) {
        int result = 0;
        result += g(a);
        return result;
    }

    public int g(int b) {
        return b+3;
    }

    // 递归举例
    public int f(int n) {
        if (n == 1) return 1;
        return f(n-1) + 3;
    }
}
