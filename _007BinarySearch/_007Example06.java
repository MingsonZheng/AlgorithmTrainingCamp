package _007BinarySearch;

public class _007Example06 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        // 从 [1, x] 中查找最后一个平方小于等于 x 的数
        int low = 1;
        int high = x / 2 + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long mid2 = (long)mid * mid;
            if (mid2 <= x) {
                long mid22 = ((long)mid + 1) * (mid + 1);
                if (mid22 <= x) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
