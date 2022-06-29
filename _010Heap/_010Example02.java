package _010Heap;

// TOP K：347. 前 K 个高频元素

import java.util.*;

public class _010Example02 {

    public static void main(String[] args) {
        var nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 哈希表统计每个数字出现的次数 count
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        // 按照 count 值构建小顶堆
        PriorityQueue<QElement> queue = new PriorityQueue<>(new Comparator<QElement>() {
            @Override
            public int compare(QElement o1, QElement o2) {
                return o1.count - o2.count;
            }
        });
        // 求 top k
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new QElement(num, count));
            } else {
                if (queue.peek().count < count) {
                    queue.poll();
                    queue.offer(new QElement(num, count));
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().val;
        }
        return result;
    }

    private static class QElement {
        int val;
        int count;
        public QElement(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
