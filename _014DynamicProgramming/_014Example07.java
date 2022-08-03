package _014DynamicProgramming;

// 70. 爬楼梯

public class _014Example07 {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs2(2));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int climbStairs2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i-1 >= 0) {
                dp[i] += dp[i-1];
            }
            if (i-2 >= 0) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
