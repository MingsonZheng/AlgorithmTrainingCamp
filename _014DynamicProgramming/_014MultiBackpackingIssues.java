package _014DynamicProgramming;

// 多重背包问题

public class _014MultiBackpackingIssues {

    // d) 装满背包有多少种装法？（计数）
    public int knapsack4(int[] weight, int count[], int n, int w) {
        int[][] dp = new int[n][w + 1];// 记录到达某个状态有几条路径

//        for (int c = 0; c <= w/weight[0] ; c++) {
        for (int c = 0; c <= Math.min(w/weight[0], count[0]) ; c++) {
            dp[0][c*weight[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {// 动态规划状态转移
//                int k = j/weight[i];
                int k = Math.min(j/weight[i], count[i]);
                for (int c = 0; c <= k; c++) {
                    dp[i][j] += dp[i-1][j-c*weight[i]];
                }
            }
        }

        return dp[n-1][w];
    }
}
