package _008HashTable;

import java.util.Arrays;
import java.util.HashSet;

// 例题 3：移除两个集合中的相同元素

public class _008Example03 {
    public static void main(String[] args) {
        var a1 = new int[]{4, 6, 3, 2, 1};
        var a2 = new int[]{3, 5, 7, 2};
        System.out.println(removeDup(a1, a2));
        a1 = new int[]{4, 6, 3, 2, 1};
        a2 = new int[]{3, 5, 7, 2};
        System.out.println(removeDup2(a1, a2));
    }

    // 基于排序 + 双指针的解决思路
    // 返回数组 a1 的新长度
    public static int removeDup2(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] == a2[j]) {
                i++;
            } else if (a1[i] < a2[j]) {
                a1[k] = a1[i];
                k++;
                i++;
            } else { // a1[i] > a2[j]
                j++;
            }
        }
        return k;
    }

    // 基于哈希表的解决思路
    // 返回数组 a1 的新长度
    public static int removeDup(int[] a1, int[] a2) {
        HashSet<Integer> s2HashTable = new HashSet<>();
        int n1 = a1.length;
        int n2 = a2.length;
        for (int i = 0; i < n2; i++) {
            s2HashTable.add(a2[i]);
        }
        int k = 0;
        for (int i = 0; i < n1; i++) {
            if (!s2HashTable.contains(a1[i])) {
                a1[k] = a1[i];
                k++;
            }
        }
        return k;
    }
}
