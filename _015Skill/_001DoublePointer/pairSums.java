package _015Skill._001DoublePointer;

// 面试题 16.24. 数对和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pairSums {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 5, 6};
        int target = 11;
        System.out.println(pairSums(nums, target));
    }

    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(nums[j]);
                results.add(result);
                i++;
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return results;
    }
}
