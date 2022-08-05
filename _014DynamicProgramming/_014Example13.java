package _014DynamicProgramming;

// 72. 编辑距离

public class _014Example13 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // dp[i][j] 表示 w1[0 ~ i-1]（长度为 i 子串）和 w2[0 ~ i-1]（长度为 j 子串）的最短编辑距离
        int dp[][] = new int[n+1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i-1] == w2[j-1]) {
                    dp[i][j] = min3(dp[i-1][j-1]+1, dp[i-1][j]+1, dp[i][j-1]);
                } else {
                    dp[i][j] = min3(dp[i-1][j-1]+1, dp[i-1][j]+1, dp[i][j-1]+1);
                }
            }
        }
        return dp[n][m];
    }

    private static int min3(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
