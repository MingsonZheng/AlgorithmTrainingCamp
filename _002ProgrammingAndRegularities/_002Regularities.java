package _002ProgrammingAndRegularities;

public class _002Regularities {

    // 找规律题例题2：剑指 Offer 61. 扑克牌中的顺子
    public boolean isStraight(int[] nums) {
        boolean[] dup = new boolean[14];
        int min = 100;
        int max = -1;
        for (int i = 0; i < 5; i++) {
            if (nums[i] != 0) {
                if (dup[nums[i]]) return false;
                else dup[nums[i]] = true;

                if (nums[i] < min) min = nums[i];
                if (nums[i] > max) max = nums[i];
            }
        }
        return (max - min) < 5;
    }

    // 找规律题例题1：阿里钉钉22届暑期实习
    public int drink(int x) {
        int count = x;// 喝了多少瓶
        int k1 = x;// 有多少个空瓶子
        int k2 = x;// 有多个个空瓶盖
        while (k1 >= 3 || k2 >= 7) {
            while (k1 >= 3) {
                int change = k1 / 3;
                count += change;
                k1 %= 3;
                k1 += change;
                k2 += change;
            }
            while (k2 >= 7) {
                int change = k2 / 7;
                count += change;
                k2 %= 7;
                k1 += change;
                k2 += change;
            }
        }
        return count;
    }
}
