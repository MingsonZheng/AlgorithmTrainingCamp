package _014DynamicProgramming;

// 1143. 最长公共子序列

public class _014Example12 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        // dp[i][j] 表示 text1[0 ~ i-1]（长度为 i 子串）和 text2[0 ~ i-1]（长度为 j 子串）的 LCS
        int dp[][] = new int[n+1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i-1] == t2[j-1]) {
                    dp[i][j] = max3(dp[i-1][j-1]+1, dp[i-1][j], dp[i][j-1]);
                } else {
                    dp[i][j] = max3(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    private static int max3(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        return max;
    }
}