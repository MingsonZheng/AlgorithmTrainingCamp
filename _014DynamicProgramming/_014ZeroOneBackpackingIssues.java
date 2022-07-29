package _014DynamicProgramming;

// 专题：适用问题（0-1 背包问题）

public class _014ZeroOneBackpackingIssues {
    private int maxW = Integer.MIN_VALUE;// 结果放到 maxW 中
    private int[] weight = {2, 2, 4, 6, 3};// 物品重量
    private int n = 5;// 物品个数
    private int w = 9;// 背包承受的最大重量

    // 回溯
    public void f(int i, int cw) {// 调用 f(0, 0)
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        f(i+1, cw);// 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i+1, cw + weight[i]);// 选择装第 i 个物品
        }
    }

    private boolean[][] mem = new boolean[5][10];

    // 回溯解法：使用备忘录解决重复子问题
    public void f2(int i, int cw) {// 调用 f(0, 0)
        if (cw == w || i == n) {// cw == w 表示装满了，i == n 表示物品都考察完了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {// 重复状态
            return;
        }
        mem[i][cw] = true;// 记录 (i, cw) 这个状态
        f(i+1, cw);// 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i+1, cw + weight[i]);// 选择装第 i 个物品
        }
    }

    // 动态规划解法
    public int knaspack(int[] weight, int n, int w) {
        boolean[][] dp = new boolean[n][w + 1];// 默认值 false
        dp[0][0] = true;
        if (weight[0] <= w) {
            dp[0][weight[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {// 遍历第 i-1 个阶段的所有可达状态
                if (dp[i-1][j] == true) {// 可达
                    dp[i][j] = true;// 推导第 i 层状态
                    if (j+weight[i] <= w) {
                        dp[i][j+weight[i]] = true;// 推导第 i 层状态
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
