public class _004Stack {
    public static void main() {
        // Java 编程语言中的栈：java.util.Stack
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(1);// 入栈
        int value = stack.pop();// 出栈
        stack.peek();// 取出栈首元素，但不出栈
    }

    // 栈的定义
    public class Stack {
        public void push(int data) {/**/}
        public int pop() {/**/ return -1;}
        public int peek() {/**/ return -1;}
    }
}
