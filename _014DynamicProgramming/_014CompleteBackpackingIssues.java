package _014DynamicProgramming;

// 完全背包问题

public class _014CompleteBackpackingIssues {

    // a) 背包可装物品总重量的最大值是多少（最值）
    public int knapsack (int[] weight, int n, int w) {
        boolean[][] dp = new boolean[n][w+1];// 默认值为 false
        for (int c = 0; c <= w/weight[0] ; c++) {
            dp[0][c*weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int k = j/weight[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j-c*weight[i]]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        for (int i = w; i >= 0 ; i--) {// 输出结果
            if (dp[n-1][i] == true) {
                return i;
            }
        }

        return 0;
    }
}
