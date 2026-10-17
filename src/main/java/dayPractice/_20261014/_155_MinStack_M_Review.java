package dayPractice._20261014;

import java.util.Stack;

public class _155_MinStack_M_Review {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public _155_MinStack_M_Review() {

    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }

    }

    public void pop() {
        int value = stack.pop();
        if (value == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
