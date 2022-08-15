package _015Skill;

// 283. 移动零（双指针）

import java.util.Arrays;

public class _015Example02 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int p = -1;
        int q = 0;
        while (q < nums.length) {
            if (nums[q] == 0) {
                q++;
                continue;
            }
            if (nums[q] != 0) {
                swap(nums, p+1, q);
                p++;
                q++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
