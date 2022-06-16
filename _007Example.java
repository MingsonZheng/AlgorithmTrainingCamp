import java.util.Arrays;

public class _007Example {

    public static void main(String[] args) {
        var a = new int[]{2, 3, 4, 4, 6, 7, 8};
        var n = 7;
        var target = 4;
        System.out.println(binarySearch_1(a, n, target));
    }

    // 例题 1：查找第一个等于 x、最后一个等于 x 的元素
    // 查找第一个等于给定值的元素
    public static int binarySearch_1(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界

            // 写注释让逻辑更清晰
            // 1. a[mid] == target
            //   1.1 mid == 0 || a[mid- 1] != target return mid;
            //   1.2 else (a[mid-1] == target) high = mid - 1
            // 2. a[mid] > target low = mid + 1
            // 3. a[mid] < target high = mid + 1

            // 2, 3, 4, 4, 6, 7, 8
            if (a[mid] == target) {// 命中
                // mid 是第一个元素，或者 mid 的前一个元素不等于 target
                if ((mid == 0) || (a[mid-1] != target)) return mid;// 真命中
                // mid 的前一个元素等于 target，需要查询前面的区间
                else high = mid - 1;// 伪命中，a[mid-1] == target
            } else if (a[mid] > target) {// 不命中
                high = mid - 1;
            } else {// 不命中，a[mid] < target
                low = mid + 1;
            }
        }
        return -1;
    }
}
