package _004StacksAndQueues;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class _004Queue {
    public void main () {
//        public interface Queue<E> extends Collection<E>

        java.util.Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);// 入队
//        queue.add(1);// 入队
        Integer value = queue.poll();// 出队
//        Integer value = queue.remove();// 出队
        queue.peek();// 取队首元素，但不出队
    }

    // 队列的定义
    public class Queue {
        public boolean enqueue (String data) {/**/ return false;}
        public String dequeue () {/**/ return "";}
        public String peek () {/**/ return "";}
    }
}
