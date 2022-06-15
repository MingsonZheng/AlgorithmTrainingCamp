public class _007BinarySearch {

    // 二分查找代码实现--非递归实现
    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;// 搜索区间：闭区间
        while (low <= high) {// 循环结束条件
            int mid = (low + high) / 2;
            if (a[mid] == value) {
                return mid;// 返回值 mid
            } else if (a[mid] < value) {
                low = mid + 1;// 更新 low
            } else {
                high = mid - 1;// 更新 high
            }
        }
        return -1;
    }
}
