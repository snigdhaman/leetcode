package stack;

import java.util.Stack;

public class LC227BasicCalculatorII {

    public int calculate (String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        int index = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + Character.getNumericValue(ch);
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || index == s.length() - 1) {
                switch (operation) {
                    case '/':
                        stack.push(stack.pop() / currentNumber);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNumber);
                        break;
                    case '+':
                        stack.push(currentNumber);
                        break;
                    case '-':
                        stack.push(-currentNumber);
                        break;
                }
                operation = ch;
                currentNumber = 0;
            }
            index++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main (String[] args) {
        LC227BasicCalculatorII lc227BasicCalculatorII = new LC227BasicCalculatorII();
        System.out.println(lc227BasicCalculatorII.calculate("3+2*2"));
        System.out.println(lc227BasicCalculatorII.calculate(" 3/2 "));
    }
}
