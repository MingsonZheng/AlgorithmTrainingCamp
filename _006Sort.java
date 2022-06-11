import java.util.Arrays;

public class _006Sort {

    public static void main(String[] args) {
        var a = new int[]{3, 8, 2, 1, 5};
        var n = 5;
        BubbleSort(a, n);// 冒泡排序
        System.out.println(Arrays.toString(a));
        a = new int[]{3, 8, 2, 1, 5};
        InsertionSort(a, n);// 插入排序
        System.out.println(Arrays.toString(a));
        a = new int[]{3, 8, 2, 1, 5};
        SelectionSort(a, n);// 选择排序
        System.out.println(Arrays.toString(a));
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
