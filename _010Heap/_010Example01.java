package _010Heap;

// 优先级队列：23. 合并K个升序链表

import java.util.Comparator;
import java.util.PriorityQueue;

public class _010Example01 {

    public static void main(String[] args) {
        var node5 = new ListNode(5);
        var node4 = new ListNode(4, node5);
        var node1 = new ListNode(1, node4);

        var node44 = new ListNode(4);
        var node3 = new ListNode(3, node44);
        var node11 = new ListNode(1, node3);

        var node6 = new ListNode(6);
        var node2 = new ListNode(2, node6);

        var lists = new ListNode[]{node1, node11, node2};
        var res = mergeKLists(lists);
        while(res.next != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<QElement> minQ = new PriorityQueue<>(new Comparator<QElement>() {
            @Override
            public int compare(QElement o1, QElement o2) {
                return o1.curNode.val - o2.curNode.val;
            }
        });
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minQ.offer(new QElement(lists[i]));
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!minQ.isEmpty()) {
            QElement element = minQ.poll();
            ListNode curNode = element.curNode;
            tail.next = element.curNode;
            tail = tail.next;
            if (curNode.next != null) {
                minQ.offer(new QElement(curNode.next));
            }
        }
        return head.next;
    }

    private static class QElement {
        ListNode curNode;
        public QElement(ListNode curNode) {
            this.curNode = curNode;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
