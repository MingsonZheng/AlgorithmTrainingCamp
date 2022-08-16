package _015Skill;

// 191. 位1的个数（位运算）

public class _015Example08 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int oneCount = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                oneCount++;
            }
            mask <<= 1;
        }
        return oneCount;
    }
}
