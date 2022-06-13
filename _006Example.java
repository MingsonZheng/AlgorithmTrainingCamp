import java.util.Arrays;
import java.util.List;

public class _006Example {
    public static void main(String[] args) {
        // 例题 4：排序预处理
        int[] data = new int[]{3, 2, 1, 6, 1, 1, 2, 2, 3, 2};
        System.out.println(MaxCount(data));
        System.out.println();

        // 例题 3：[147. 对链表进行插入排序](https://leetcode.cn/problems/insertion-sort-list/)
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = InsertionSortList(head);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
        System.out.println();

        // 例题 2：TOP K，[215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)
        var nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(FindKthLargest(nums, 2));
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(FindKthLargest(nums, 4));
        System.out.println();

        // 例题 1：特殊排序
        nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(Exchange(nums)));
    }

    // 例题 4：排序预处理
    public static int MaxCount(int[] data) {
        Arrays.sort(data);
        int n = data.length;
        int prev = -1;
        int count = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (data[i] == prev) {
                count++;
                if (max < count) max = count;
            } else {
                count = 1;
                prev = data[i];
                if (max < count) max = count;
            }
        }
        return max;
    }

    // 例题 3：[147. 对链表进行插入排序](https://leetcode.cn/problems/insertion-sort-list/)
    public static ListNode InsertionSortList(ListNode head) {
        if (head == null) return null;
        // 存储已经排好序的节点
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE, null);

        // 遍历节点
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;

            // 寻找 p 节点插入的位置，插入到哪个节点后面
            ListNode q = dummyHead;// 初始化值
            while (q.next != null && q.next.val <= p.val) {// 循环结束条件
                q = q.next;
            }
            // 将 p 节点插入
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        return dummyHead.next;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 例题 2：TOP K，[215. 数组中的第K个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/)
    public static int FindKthLargest(int[] nums, int k) {
        if (nums.length < k) return -1;
        return quickSort(nums, 0, nums.length-1, k);
    }

    private static int quickSort(int[] nums, int p, int r, int k) {
        if (p > r) return -1;// 比如数组有 8 个元素要找第 10 大，就返回
        int q = partition(nums, p, r);
        if (q-p+1 == k) {
            return nums[q];
        } else if (q-p+1 < k) {
            return quickSort(nums, q+1, r, k-(q-p+1));
        } else {
            return quickSort(nums, p, q-1, k);
        }
    }

    // 双指针
    private static int partition(int[] nums, int p, int r) {
        int i = p;
        int j = r-1;
        while (i < j) {
            while (i < j && nums[i] > nums[r]) {
                i++;
            }
            while (i < j && nums[j] <= nums[r]) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        // 假设分区元素是 r = 4
        // i = 3，j = 5
        // 上面代码的 if 判断中 i < j，所以 i 和 j 的值发生交换，i = 5，j = 3
        // 然后 i++，j--，所以 i = 3，j = 5
        // 此时如果用 j 的值和分区元素 r 交换，则 5 出现在 4 的右侧
        // 这是不对的，不符合由大到小排序，所以下面需要 j + 1
        //
        // 如果数组只有一个元素，那么上面代码 p = 0，r = 0，i = 0，j = -1
        // 上面的判断全部跳过，到下面会报错，因为下标 j = -1，所以需要加一个判断 j >= p
        if (j >= p && nums[j] < nums[r]) {
            swap(nums, j, r);
            return j;
        } else {
            swap(nums, j+1, r);
            return j+1;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 例题 1：特殊排序
    public static int[] Exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
