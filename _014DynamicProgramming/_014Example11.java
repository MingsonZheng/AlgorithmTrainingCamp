package _014DynamicProgramming;

// 139. 单词拆分

import java.util.ArrayList;
import java.util.List;

public class _014Example11 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示长度为 i 的字符串是可拆分的
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) { // i 表示长度
            for (String word : wordDict) { // 走法
                int len = word.length();
                int startPosition = i - len;
                if (startPosition >= 0 && s.startsWith(word, startPosition) && dp[i-len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
