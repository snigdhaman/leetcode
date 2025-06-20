package stack;

import java.util.Map;
import java.util.Stack;

public class LC155MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public LC155MinStack () {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push (int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            int minVal = Math.min(val, minStack.peek());
            minStack.push(minVal);
        }
        else minStack.push(val);
    }

    public void pop () {
        if (!stack.isEmpty()) {
            stack.pop();
        }
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int top () {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }

    public int getMin () {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        LC155MinStack lc155MinStack = new LC155MinStack();
        lc155MinStack.push(-2);
        lc155MinStack.push(0);
        lc155MinStack.push(-3);
        System.out.println(lc155MinStack.getMin());
        lc155MinStack.pop();
        System.out.println(lc155MinStack.top());
        System.out.println(lc155MinStack.getMin());
    }
}
