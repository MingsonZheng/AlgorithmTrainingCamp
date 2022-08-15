package _015Skill;

// 238. 除自身以外数组的乘积（前缀后缀统计）

import java.util.Arrays;

public class _015Example07 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            leftProducts[i] = product;
        }

        product = 1;
        for (int i = n-1; i >= 0; i--) {
            product *= nums[i];
            rightProducts[i] = product;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            if (i-1 >= 0) {
                result[i] *= leftProducts[i-1];
            }
            if (i+1 < n) {
                result[i] *= rightProducts[i+1];
            }
        }
        return result;
    }

    // 用 result 替换 left
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i = n-1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
