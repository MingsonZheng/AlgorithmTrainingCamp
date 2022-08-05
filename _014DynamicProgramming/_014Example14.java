package _014DynamicProgramming;

// 300. 最长递增子序列

public class _014Example14 {
    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;

        int[] listToMin = new int[n+1];// 记录当考察到第 i 个元素时，当前所有可能的子序列长度，以及每个子序列长度对应的序列中最后一个元素的最小值
        int k = 0;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int len = beforeSearch(listToMin, k, nums[i]);
            if (len == -1) {
                dp[i] = 1;
            } else {
                dp[i] = len+1;
            }
            if (dp[i] > k) {
                k = dp[i];
                listToMin[dp[i]] = nums[i];
            } else if (listToMin[dp[i]] > nums[i]) {
                listToMin[dp[i]] = nums[i];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }

    /**
     * 查找最后一个比 target 小的元素位置
     * */
    private static int beforeSearch(int[] a, int k, int target) {
        int low = 1;
        int high = k;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < target) {
                if (mid == k || a[mid + 1] >= target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
