package _014DynamicProgramming;

// 专题：适用问题（二维费用背包问题）

public class _014TwoDimensionalCostsBackpackingIssues {
    private int maxV = Integer.MIN_VALUE;
    private int[] weight = {2, 2, 4, 6, 3};
    private int[] value = {3, 4, 8, 9, 6};
    private int n = 5;// 物品个数
    private int w = 9;// 背包承受的最大重量

    // 回溯
    public void f (int i, int cw, int cv) {// 调用 f(0, 0, 0)
        if (cw == w || i == n) {// cw == w 表示装满了，i == n 表示物品都考察完了
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        f(i+1, cw, cv);// 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i+1, cw + weight[i], cv + value[i]);// 选择装第 i 个物品
        }
    }

    // 动态规划
    public int knapsack (int[] weight, int []value, int n, int w) {
        int[][] dp = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;
        if (weight[0] <= w) {
            dp[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (dp[i-1][j] == Integer.MIN_VALUE) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);// 原来的值与只放置新物品的值哪个大
                if (j + weight[i] <= w) {// 未超过，在原来的基础上添加新物品
                    dp[i][j+weight[i]] = Math.max(dp[i][j+weight[i]], dp[i-1][j] + value[i]);
                }
            }
        }

        // 扫描最后一行，求总价值最大的
        int res = Integer.MIN_VALUE;
        for (int j = 0; j <= w; j++) {
            if (res < dp[n-1][j]) {
                res = dp[n-1][j];
            }
        }
        return res;
    }
}
