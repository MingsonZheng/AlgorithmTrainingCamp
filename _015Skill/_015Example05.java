package _015Skill;

// 剑指 Offer 48. 最长不含重复字符的子字符串（滑动窗口）

import java.util.HashSet;
import java.util.Set;

public class _015Example05 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int p = 0;
        int q = 0;
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while (q < n) {
            char c = s.charAt(q);
            if (!set.contains(c)) {
                set.add(c);
                q++;
                if (q-p > maxLen) maxLen = q-p;
                continue;
            }
            while (set.contains(c)) {
                set.remove(s.charAt(p));
                p++;
            }
        }
        return maxLen;
    }
}
