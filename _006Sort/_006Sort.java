package _006Sort;

import java.util.Arrays;

public class _006Sort {

    public static void main(String[] args) {
        var a = new int[]{3, 8, 2, 1, 5};
        var n = 5;
        QuickSort(a, n);// 归并排序
        System.out.println(Arrays.toString(a));

        a = new int[]{3, 8, 2, 1, 5};
        MergeSort(a, n);// 归并排序
        System.out.println(Arrays.toString(a));

        a = new int[]{3, 8, 2, 1, 5};
        SelectionSort(a, n);// 选择排序
        System.out.println(Arrays.toString(a));

        a = new int[]{3, 8, 2, 1, 5};
        InsertionSort(a, n);// 插入排序
        System.out.println(Arrays.toString(a));

        a = new int[]{3, 8, 2, 1, 5};
        BubbleSort(a, n);// 冒泡排序
        System.out.println(Arrays.toString(a));
    }

    // 快速排序
    public static void QuickSort(int[] a, int n) {
        quickSort_r(a, 0, n-1);
    }

    private static void quickSort_r(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r);// 获取分区点下标
        quickSort_r(a, p, q-1);
        quickSort_r(a, q+1, r);
    }

    // 代码简单，但难理解，双指针的方法更好理解
    // [p, i] 比分区点小；[i+1, j) 未处理；[j, r-1] 比分区点大
    private static int partition(int[] a, int p, int r) {
        int i = p - 1;// [p, i] 表示小于 pivot 值的元素
        for (int j = p; j < r; j++) {// 用 j 来遍历整个数组 [p, r]
            if (a[j] < a[r]) {
                swap(a, i+1, j);
                i++;
            }
        }
        swap(a, i+1, r);
        return i+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 归并排序
    public static void MergeSort(int[] a, int n){
        mergeSort_r(a, 0, n-1);
    }

    private static void mergeSort_r(int[] a, int p, int r){
        if (p >= r) return;

        int q = p + (r - p) / 2;
        mergeSort_r(a, p, q);
        mergeSort_r(a, q+1, r);

        // 将 a[p...q] 和 a[q+1...r] 合并为 a[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r-p+1];// 申请一个大小跟 a[p...r] 一样的临时数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = a[i++];
        }
        while (j <= r)  {
            tmp[k++] = a[j++];
        }
        // 将 tmp 中的数组拷贝回 a[p...r]
        for (int l = 0; l <= r-p; l++) {
            a[p+l] = tmp[l];
        }
    }

    // 选择排序
    public static void SelectionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {// 循环 n-1 次就可以
            int minPos = i;
            for (int j = i; j < n; j++) {// 查找 min
                if (a[j] < a[minPos]) {
                    minPos = j;
                }
            }
            // 交换元素
            int tmp = a[i];
            a[i] = a[minPos];
            a[minPos] = tmp;
        }
    }

    // 插入排序
    public static void InsertionSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {// [0, i) 已排序
            int value = a[i];
            int j = i - 1;
            for (; j >= 0 ; j--) {// 查找插入的位置
                if (a[j] > value) {
                    a[j+1] = a[j];// 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value;// 插入数据
        }
    }

    // 冒泡排序
    public static void BubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {// 第几趟冒泡
            boolean flag = false;// 提前退出冒泡循环的标志位
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) {// 交换相邻的两个元素
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;// 表示有数据交换
                }
            }
            if (!flag) break;// 没有数据交换，提前退出
        }
    }
}
