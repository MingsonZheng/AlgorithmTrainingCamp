package _010Heap;

// 求中位数、百分位数：295. 数据流的中位数

import java.util.Comparator;
import java.util.PriorityQueue;

public class _010Example03 {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

    static class MedianFinder {

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (maxQueue.isEmpty() || num <= maxQueue.peek()) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
            while (maxQueue.size() < minQueue.size()) {
                Integer e = minQueue.poll();
                maxQueue.add(e);
            }
            while (minQueue.size() < maxQueue.size() - 1) {
                Integer e = maxQueue.poll();
                minQueue.add(e);
            }
        }

        public double findMedian() {
            if (maxQueue.size() > minQueue.size()) {
                return maxQueue.peek();
            } else {
                return (maxQueue.peek() + minQueue.peek()) / 2f;
            }
        }
    }

    private static PriorityQueue<Integer> minQueue = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    private static PriorityQueue<Integer> maxQueue = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
}
