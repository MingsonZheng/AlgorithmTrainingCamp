public class _003Example {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 例题3：876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 例题2：203. 移除链表元素
    // 改变链表的万能写法
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (p.val != val) {
                p.next = null;
                tail.next = p;
                tail = p;
            }
            p = tmp;
        }
        return newHead.next;
    }

    // 第二种
    // 添加一个虚拟的节点 newHead，让 prev = newHead（尝试使用一个技巧）
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return newHead.next;
    }

    // 第一种
    // 最后再特殊处理一些头节点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
