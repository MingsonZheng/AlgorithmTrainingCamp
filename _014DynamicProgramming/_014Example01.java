package _014DynamicProgramming;

// 64. 最小路径和

public class _014Example01 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int len = 0;
        // 第一行和第一列没办法通过左和上的元素推导，所以直接初始化
        for (int i = 0; i < m; i++) {
            len += grid[i][0];
            dp[i][0] = len;
        }
        len = 0;
        for (int j = 0; j < n; j++) {
            len += grid[0][j];
            dp[0][j] = len;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
