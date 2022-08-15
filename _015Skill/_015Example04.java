package _015Skill;

// 剑指 Offer 57 - II. 和为s的连续正数序列（滑动窗口）

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015Example04 {

    public static void main(String[] args) {
        int[][] results = findContinuousSequence(9);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int p = 1;
        int q = 2;
        int sum = 3;
        while (p < q) {
            if (sum == target) {
                int[] arr = new int[q-p+1];
                for (int i = p; i <= q; i++) {
                    arr[i-p] = i;
                }
                result.add(arr);
                sum -= p;
                p++;
                q++;
            } else if (sum > target) {
                sum -= p;
                p++;
            } else {
                q++;
                sum += q;
            }
        }
        int[][] resultArr = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
