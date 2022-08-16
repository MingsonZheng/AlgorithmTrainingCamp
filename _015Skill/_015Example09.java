package _015Skill;

// 461. 汉明距离（位运算）

public class _015Example09 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int r = x ^ y;
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            if ((r & mask) != 0) count++;
            mask *= 2;
        }
        return count;
    }
}
