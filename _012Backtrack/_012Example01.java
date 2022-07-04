package _012Backtrack;

// 回溯例题1、全排列

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _012Example01 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(permute(nums).toArray()));
    }

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path);
        return result;
    }

    // 路径：记录在 path 中
    // 决策阶段：k
    // 可选列表：nums 中除掉存在于 path 中的数据
    private static void backtrack(int[] nums, int k, List<Integer> path) {
        // 结束条件
        if (k == nums.length) {
            result.add(new ArrayList<>(path));// 必须 new 一个
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            // 做选择
            path.add(nums[i]);
            // 递归
            backtrack(nums, k+1, path);
            // 撤销选择
            path.remove(path.size()-1);//删除最后一个元素
        }
    }
}
