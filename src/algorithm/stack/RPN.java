package algorithm.stack;

import java.util.Stack;

/**
 * 计算逆波兰式（后缀表达式）的值
 */
public class RPN {
    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String e : tokens) {
            if (e.equals("+")) {
                if (stack.size() < 2) {
                    return Integer.MIN_VALUE;
                }
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first + second);
            } else if (e.equals("-")) {
                if (stack.size() < 2) {
                    return Integer.MIN_VALUE;
                }
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (e.equals("*")) {
                if (stack.size() < 2) {
                    return Integer.MIN_VALUE;
                }
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first * second);
            } else if (e.equals("/")) {
                if (stack.size() < 2) {
                    return Integer.MIN_VALUE;
                }
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(e));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
