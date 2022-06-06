import java.util.ArrayList;
import java.util.List;

public class _005RecursionAndPartition {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        reversePrint(head);
        for (Integer k : result) {
            System.out.println(k);
        }
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
    public int f5(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;
        if (n == 3) return 8;
        return 2*f5(n-1) - f5(n-4);
    }

    // 备忘录
    private int[] mem;
    public int f4(int n) {
        mem = new int[n+1];
        return f_r(n);
    }

    public int f_r(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] != 0) return mem[n];
        mem[n] = f_r(n-1) + f_r(n-2);
        return mem[n];
    }

    // 递归函数
    public int f3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return f3(n-1) + f3(n-2);
    }

    // 函数调用栈
    public int f2(int a) {
        int result = 0;
        result += g(a);
        return result;
    }

    public int g(int b) {
        return b+3;
    }

    // 递归举例
    public int f(int n) {
        if (n == 1) return 1;
        return f(n-1) + 3;
    }
}
