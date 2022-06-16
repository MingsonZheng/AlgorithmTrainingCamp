package _004StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;
import static java.lang.Character.isDigit;

public class _004Example {
    public static void main(String[] args) {
        // 例题4：单调栈- [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/)
        int[] T = new int[] {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
        int[] res2 = dailyTemperatures2(T);
        System.out.println(Arrays.toString(res2));
        System.out.println();

        // 例题3：[面试题 16.26. 计算器](https://leetcode.cn/problems/calculator-lcci/) 求表达式值
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println();

        // 例题2：删除连续重复字符（腾讯实习）
        System.out.println(remove("abbbc"));
        System.out.println(remove("abbbaac"));
        System.out.println(remove("abbaaabcc"));
    }

    // 例题4：单调栈- [739. 每日温度](https://leetcode.cn/problems/daily-temperatures/)
    // 2）单调栈解法
    public static int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int result[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && T[stack.peek()] < T[i]) {
                int idx = stack.peek();
                result[idx] = i - idx;
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    // 1) 暴力解法
    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (T[j] > T[i]) {
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

    // 例题3：[面试题 16.26. 计算器](https://leetcode.cn/problems/calculator-lcci/) 求表达式值
    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {// 跳过空格
                i++;
            } else if (isDigit(c)) {// 数字
                int number = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(number);// 数字直接进数字栈
            } else {// 运算符
                if (ops.isEmpty() || prior(c, ops.peek())) {// 运算符 c > 栈顶运算符，c 直接入栈
                    ops.push(c);
                } else {
                    while (!ops.isEmpty() && !prior(c, ops.peek())) {// 运算符 c <= 栈顶运算符，栈顶出栈计算
                        fetchAndCal(nums, ops);
                    }
                    ops.push(c);
                }
                i++;
            }
        }

        while(!ops.isEmpty()) {
            fetchAndCal(nums, ops);
        }

        return nums.pop();
    }

    private static boolean prior(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        }
        return false;
    }

    private static int cal(char op, int number1, int number2) {
        switch (op) {
            case '+': return number1 + number2;
            case '-': return number1 - number2;
            case '*': return number1 * number2;
            case '/': return number1 / number2;
        }
        return -1;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static void fetchAndCal(Stack<Integer> nums, Stack<Character> ops) {
        int number2 = nums.pop();
        int number1 = nums.pop();
        char op = ops.pop();
        int ret = cal(op, number1, number2);
        nums.push(ret);
    }

    // 例题2：删除连续重复字符（腾讯实习）
    // 字符串删除掉连续的 3 个重复的字符。比如“abbbc”，返回“ac”；“abbbaac”，返回“c"（腾讯 CSIG 22 届暑期实习）
    public static class CharWithCount {
        public char c;
        public int count;
        public CharWithCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static String remove(String str) {
        Stack<CharWithCount> stack = new Stack<>();
        Stack<CharWithCount> tmpStack = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {// 顺序处理每个字符
            char c = str.charAt(i);
            // 栈为空
            if (stack.isEmpty()) {
                stack.push(new CharWithCount(c, 1));
                continue;
            }
            // 栈不为空，但栈顶字符跟 c 比较，如果不相同
            CharWithCount topChar = stack.peek();
            if (topChar.c != c) {
                stack.push(new CharWithCount(c, 1));
                continue;
            }
            // 栈顶元素跟 c 相同，并且满足连连消
            if (topChar.count == 2) {
                stack.pop();
                continue;
            }
            // 栈顶元素跟 c 相同，但不满足连连消
            topChar.count++;
        }

        // 用栈将数据颠倒一下
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        String res = "";
        while (!tmpStack.isEmpty()) {
            var tmp = tmpStack.pop();
            for (int i = 0; i < tmp.count; i++) {
                res += tmp.c;
            }
        }
        return res;
    }

    // 例题1：用栈实现队列（字节实习）
    // 解法二：入队-倒腾两个栈；出队-直接出栈
    public class StackToQueue2 {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public StackToQueue2() {}

        public void enqueue(Integer data) {// 入队-倒腾两个栈
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            stack.push(data);
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }

        public Integer dequeue() {// 出队-直接出栈
            if (stack.isEmpty()) return null;
            return stack.pop();
        }
    }

    // 解法一：入队-直接入栈；出队-倒腾两个栈
    public class StackToQueue {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> tmpStack = new Stack<>();

        public StackToQueue() {}

        public void enqueue(Integer data) {// 入队-直接入栈
            stack.push(data);
        }

        public Integer dequeue() {// 出队-倒腾两个栈
            if (stack.isEmpty()) return null;
            while (!stack.isEmpty()) {
                tmpStack.push(stack.pop());
            }
            Integer result = tmpStack.pop();
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
            return result;
        }
    }
}
