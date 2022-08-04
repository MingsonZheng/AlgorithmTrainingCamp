package _014DynamicProgramming;

// 剑指 Offer 14- I. 剪绳子

public class _014Example09 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
    }

    // 递归转非递归写法，类比上台阶
    public static int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        // dp[i] 表示长度为 i 的最大乘积
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i] < j*dp[i-j]) {
                    dp[i] = j*dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
