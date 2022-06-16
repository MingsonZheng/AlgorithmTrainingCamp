package _005RecursionAndPartition;

import java.util.ArrayList;
import java.util.List;

public class _005Example {
    public static void main(String[] args) {
        // 例题3：剑指 Offer 06. 从尾到头打印链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        reversePrint(head);
        for (Integer k : result) {
            System.out.println(k);
        }

        // 例题2：细胞分裂
        System.out.println(cellDivision(4));
        System.out.println(cellDivision(5));

        // 例题1：70. 爬楼梯
        System.out.println(climbStairs(3));
    }

    // 例题3：剑指 Offer 06. 从尾到头打印链表
    static List<Integer> result = new ArrayList<>();

    public static int[] reversePrint(ListNode head) {
        reverseTravel(head);
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (Integer k : result) {
            resultArr[i++] = k;
        }
        return resultArr;
    }

    private static void reverseTravel(ListNode head) {
        if (head == null) return;
        reverseTravel(head.next);
        result.add(head.val);
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 例题2：细胞分裂
    public static int cellDivision(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        if (n == 3) return 8;
        return 2 * cellDivision(n-1) - cellDivision(n-4);
    }

    // 例题1：70. 爬楼梯
    private static int[] mem;
    public static int climbStairs(int n) {
        mem = new int[n+1];
        return f_r(n);
    }

    public static int f_r(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] != 0) return mem[n];
        mem[n] = f_r(n-1) + f_r(n-2);
        return mem[n];
    }
}
