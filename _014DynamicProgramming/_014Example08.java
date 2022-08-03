package _014DynamicProgramming;

// 322. 零钱兑换

public class _014Example08 {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }

    // 爬楼梯问题思路
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];// int dp[amount + 1] dp[i] 表示凑够 i 元最少需要多少硬币
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;// 凑够 0 元需要多少硬币
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i-coins[j] >= 0 &&
                dp[i-coins[j]] != Integer.MAX_VALUE &&
                dp[i-coins[j]] + 1 < dp[i]) {// dp[i] = min(dp[i-1]、dp[i-2]、dp[i-5]) + 1
                    dp[i] = dp[i-coins[j]] + 1;
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    // 完全背包问题思路
    public static int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        // 第 i 个硬币决策完之后，凑足金额 j 需要的最少硬币数 dp[i][j]
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int c = 0; c <= amount/coins[0]; c++) {
            dp[0][c*coins[0]] = c;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int k = j/coins[i];
                for (int c = 0; c <= k; c++) {
                    if (dp[i-1][j-c*coins[i]] != Integer.MAX_VALUE &&
                    dp[i-1][j-c*coins[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j-c*coins[i]] + c;
                    }
                }
            }
        }
        if (dp[n-1][amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n-1][amount];
    }
}
