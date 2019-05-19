package algorithm.stack;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> s;
    private Stack<Integer> minS;
    private MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }

    private void push(int x) {
        s.push(x);
        if (minS.empty() || (x <= minS.peek())) {
            minS.push(x);
        }
    }

    private void pop() {
        if (s.peek().equals(minS.peek())) {
            minS.pop();
        }
        s.pop();
    }

    private int top() {
        return s.peek();
    }

    private int getMin() {
        return minS.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
