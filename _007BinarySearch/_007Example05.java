package _007BinarySearch;

// 例题 5：查找峰值
// 852. 山脉数组的峰顶索引

public class _007Example05 {
    public static void main(String[] args) {
        var arr = new int[]{1, 2, 4, 8, 5, 3, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;// 之前的代码 mid = (low + high) / 2，但是 low + high 可能会数组越界
            if (mid == 0) {// 处理下面代码数组越界
                low = mid + 1;
            } else if (mid == n-1) {// 处理下面代码数组越界
                high = mid - 1;
            } else if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {// 命中
                return mid;
            } else if (arr[mid] > arr[mid-1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
