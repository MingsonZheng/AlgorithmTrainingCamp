package _015Skill;

// 位运算

public class _015BitOperations {

    public static void main(String[] args) {

        int a = 242;
        int[] bits = new int[32];

        // 十进制数 a 转化成二进制数组 bits[]
        int k = 0;
        while (a != 0) {
            bits[k++] = a & 1;
            a >>= 1;
        }

        // 十进制数 a 转化成二进制数组 bits[]
        int mask = 1; // 2^0 ~ 2^31
        for (int i = 0; i < 32; i++) {
            if ((a & mask) == 1) {
                bits[i] = 1;
            }
            mask <<= 1;
        }

        // bits[k] 二进制转化成十进制数 b
        int b = 0;
//        int mask = 1; // 2^0 ~ 2^31
        for (int i = 0; i < k; i++) {
            b += bits[i]*mask;
            mask <<= 1;
        }

        // bits[k] 二进制转化成十进制数 c
        int c = 0;
        for (int i = k-1; i >= 0; i++) {
            c = (c<<1) + bits[i];
        }
    }
}
