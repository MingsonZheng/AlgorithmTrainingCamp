package _012Backtrack;

// 回溯例题4、所有的组合：78. 子集

import java.util.ArrayList;
import java.util.List;

public class _012Example04 {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets (int[] nums) {
        backtrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

    // k 表示阶段
    // path 表示路径
    // 可选列表：nums[k] 选还是不选
    private void backtrack(int[] nums, int k, List<Integer> path) {
        if (k == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        // 不选
        backtrack(nums, k+1, path);
        // 选
        path.add(nums[k]);
        backtrack(nums, k+1, path);
        path.remove(path.size()-1);
    }
}
