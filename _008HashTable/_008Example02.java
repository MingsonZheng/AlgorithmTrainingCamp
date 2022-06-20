package _008HashTable;

// 例题 2：三数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _008Example02 {
    public static void main(String[] args) {
        var nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
        nums = new int[]{};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
        nums = new int[]{0};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);// 避免重复
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);// key 是元素，value 是下标，这样可以去重
        }
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;// 避免 a 重复
            for (int j = i+1; j < n; j++) {
                if (j != i+1 && nums[j] == nums[j-1]) continue;// 避免 b 重复
                int c = -1*(nums[i]+nums[j]);
                if (!hashMap.containsKey(c)) {
                    continue;
                }
                int k = hashMap.get(c);
                if (k > j) {// 哈希表保证了不存在 c 重复的情况，下标 a < b < c，即 i < j < k
                    List<Integer> resultItem = new ArrayList<>();
                    resultItem.add(nums[i]);
                    resultItem.add(nums[j]);
                    resultItem.add(nums[k]);
                    result.add(resultItem);
                }
            }
        }
        return result;
    }
}
