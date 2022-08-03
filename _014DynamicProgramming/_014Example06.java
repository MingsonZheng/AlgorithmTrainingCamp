package _014DynamicProgramming;

// 309. 最佳买卖股票时机含冷冻期

public class _014Example06 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][4];
        // dp[i][0] 表示第 i 天持有股票时的利润
        // dp[i][1] 表示第 i 天不持有股票时的利润（当天刚卖掉）
        // dp[i][2] 表示第 i 天不持有股票时的利润（冷冻期）
        // dp[i][3] 表示第 i 天不持有股票时的利润（非冷冻期）
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = max3(dp[i-1][0], dp[i-1][2] - prices[i], dp[i-1][3] - prices[i]);// 持有股票那必然不可能是刚卖掉
            dp[i][1] = dp[i-1][0] + prices[i];// 刚卖掉那必然是持有股票
            dp[i][2] = dp[i-1][1];// 冷冻期不变
            dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3]);// 非冷冻期那必然不可能是刚卖掉
        }
        return max4(dp[n-1][0], dp[n-1][1], dp[n-1][2], dp[n-1][3]);
    }

    private static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    private static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }
        return max;
    }
}
