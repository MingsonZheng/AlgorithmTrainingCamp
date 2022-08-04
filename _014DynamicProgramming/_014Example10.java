package _014DynamicProgramming;

// 剑指 Offer 46. 把数字翻译成字符串

import java.util.ArrayList;
import java.util.List;

public class _014Example10 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        // 把十进制转化成数字数组
        List<Integer> digitList = new ArrayList<>();
        while (num != 0) {
            digitList.add(num%10);
            num /= 10;
        }
        int n = digitList.size();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = digitList.get(n-i-1);
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        // dp[i] 表示 digits[0 ~ i-1]（长度为 i）转化为字母有多少种方法
        // dp[i] = dp[i-1] + dp[i-2]（digits[i-2, i-1] 可翻译）
        // dp[i] = dp[i-1]（digits[i-2, i-1] 不可翻译）
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            if (i-2 >= 0 && isValid(digits[i-2], digits[i-1])) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    private static boolean isValid(int a, int b) {
        if (a == 1) {
            return true;
        }
        if (a == 2 && b >= 0 && b <= 5) {
            return true;
        }
        return false;
    }
}
