package _007BinarySearch;

// 例题 2：查找第一个大于等于 x、最后一个小于等于 x 的元素

public class _007Example02 {
    public static void main(String[] args) {
        var a = new int[]{2, 3, 4, 4, 6, 7, 8};
        var n = 7;
        var target = 4;

        // 查找最后一个小于等于给定值的元素
        System.out.println(binarySearch_4(a, n, target));
        // 查找第一个大于等于给定值的元素
        System.out.println(binarySearch_3(a, n, target));
    }

    // 查找最后一个小于等于给定值的元素
    public static int binarySearch_4(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界
            // 2, 3, 4, 4, 6, 7, 8
            if (a[mid] <= target) {// 命中
                // mid 是最后一个元素，或者 mid 的后一个元素不等于 target
                if ((mid == 0) || (a[mid+1] > target)) return mid;// 真命中
                    // mid 的后一个元素等于 target，需要查询前面的区间
                else low = mid + 1;// 伪命中，a[mid-1] >= target
            } else {// 不命中，a[mid] < target
                high = mid - 1;
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素
    public static int binarySearch_3(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界
            // 2, 3, 4, 4, 6, 7, 8
            if (a[mid] >= target) {// 命中
                // mid 是最后一个元素，或者 mid 的后一个元素不等于 target
                if ((mid == 0) || (a[mid-1] < target)) return mid;// 真命中
                    // mid 的前一个元素大于等于 target，需要查询前面的区间
                else high = mid - 1;// 伪命中，a[mid-1] >= target
            } else {// 不命中，a[mid] < target
                low = mid + 1;
            }
        }
        return -1;
    }
}
