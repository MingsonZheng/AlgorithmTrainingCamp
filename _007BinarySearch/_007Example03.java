package _007BinarySearch;

public class _007Example03 {

// 例题 3：循环有序数组中查找元素 x（有重复数据、没有重复数据）

    public static void main(String[] args) {
        var a = new int[]{7, 9, 10, 11, 15, 1, 2, 3, 5, 6};
        var n = 10;
        var target = 11;

        // 无重复数据的循环有序数组中查找给定
        System.out.println(binarySearch_5(a, n, target));
    }

    // 无重复数据的循环有序数组中查找给定
    public static int binarySearch_5(int[] a, int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界
            // 7, 9, 10, 11, 15, 1, 2, 3, 5, 6
            if (a[mid] == target) {// 命中
                return mid;
            } else if (a[low] <= a[mid]) {// 左边有序，右边循环有序
                if (target >= a[low] && target < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// 右边有序，左边循环有序
                if (target > a[mid] && target <= a[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
