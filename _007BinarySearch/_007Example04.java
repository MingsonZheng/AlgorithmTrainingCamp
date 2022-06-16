package _007BinarySearch;

// 例题 4：无重复数据的循环有序数组中查找最小值

public class _007Example04 {
    public static void main(String[] args) {
        var a = new int[]{7, 9, 10, 11, 15, 1, 2, 3, 5, 6};
        var n = 10;
        var target = 11;

        // 无重复数据的循环有序数组中查找最小值
        System.out.println(binarySearch_7(a, n, target));
    }

    // 无重复数据的循环有序数组中查找最小值
    public static int binarySearch_7(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界
            // 特殊处理 low = high 的情况
            if (low == high) {
                return mid;
            }
            // 7, 9, 10, 11, 15, 1, 2, 3, 5, 6
            // 先处理命中情况，后处理不命中
            if ((mid != 0 && a[mid] < a[mid-1]) || (mid == 0 && a[mid] < a[high])) {
                return mid;
            } else if (a[mid] > a[high]) {// 右循环有序
                low = mid + 1;
            } else {// 右侧非循环有序；左侧循环有序
                high = mid - 1;
            }
        }
        return -1;
    }
}
