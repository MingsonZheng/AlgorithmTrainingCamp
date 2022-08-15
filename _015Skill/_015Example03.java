package _015Skill;

// 面试题 16.06. 最小差（双指针）

import java.util.Arrays;

public class _015Example03 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 15, 11, 2};
        int[] b = new int[]{23, 127, 235, 19, 8};
        System.out.println(smallestDifference(a, b));
    }

    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;
        long minRet = Long.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] >= b[j]) {
                minRet = Math.min(minRet, (long)a[i]-b[j]);
                j++;
            } else {
                minRet = Math.min(minRet, (long)b[j]-a[i]);
                i++;
            }
        }
        return (int)minRet;
    }
}
