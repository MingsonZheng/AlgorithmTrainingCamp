package _014DynamicProgramming;

// 完全背包问题

public class _014CompleteBackpackingIssues {

    // a) 背包可装物品总重量的最大值是多少（最值）
    public int knapsack (int[] weight, int n, int w) {
        boolean[][] dp = getBooleans(new boolean[n][w + 1], w, weight, n);

        for (int i = w; i >= 0 ; i--) {// 输出结果
            if (dp[n-1][i] == true) {
                return i;
            }
        }

        return 0;
    }

    private boolean[][] getBooleans(boolean[][] n, int w, int[] weight, int n1) {
        boolean[][] dp = n;// 默认值为 false
        for (int c = 0; c <= w / weight[0] ; c++) {
            dp[0][c* weight[0]] = true;
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 0; j <= w; j++) {
                int k = j/ weight[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j-c* weight[i]]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp;
    }

    // b) 是否能装满整个背包？（可行）
    public boolean knapsack2(int[] weight, int n, int w) {
        boolean[][] dp = getBooleans(new boolean[n][w + 1], w, weight, n);

        return dp[n-1][w];
    }

    // c) 正好装满背包最少需要多少物品？（最值）
    public int knapsack3(int[] weight, int n, int w) {
        int[][] dp = new int[n][w + 1];// 记录到达某个状态，最少物品数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int c = 0; c <= w/weight[0] ; c++) {
            dp[0][c*weight[0]] = c;
        }

        for (int i = 1; i < n; i++) {// 动态规划状态转移
            for (int j = 0; j <= w; j++) {
                int k = j/weight[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j-c*weight[i]] != Integer.MAX_VALUE &&
                    dp[i-1][j-c*weight[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j-c*weight[i]] + c;
                    }
                }
            }
        }
        return dp[n-1][w];
    }

    // d) 装满背包有多少种装法？（计数）
    public int knapsack4(int[] weight, int n, int w) {
        int[][] dp = new int[n][w + 1];// 记录到达某个状态有几条路径

        for (int c = 0; c <= w/weight[0] ; c++) {
            dp[0][c*weight[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {// 动态规划状态转移
                int k = j/weight[i];
                for (int c = 0; c <= k; c++) {
                    dp[i][j] += dp[i-1][j-c*weight[i]];
                }
            }
        }

        return dp[n-1][w];
    }
}
