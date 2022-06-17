package _008HashTable;

// 例题 1：两数之和

import java.util.Arrays;
import java.util.HashMap;

public class _008Example01 {
    public static void main(String[] args) {
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    // 暴力枚举：两层循环，a + b = target
    //新思路：b = target - a，寻找元素 b 等于 target - a
    //使用哈希表减低时间复杂度
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // 哈希表，key 是数字本身，value 是下标
        // 通过这个 map 可以快速地知道某个 key 是否存在，快速通过 key 获取 value
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashTable.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                int value = hashTable.get(target - nums[i]);
                if (value != i) {
                    return new int[]{i, value};
                }
            }
        }
        return new int[0];
    }
}
