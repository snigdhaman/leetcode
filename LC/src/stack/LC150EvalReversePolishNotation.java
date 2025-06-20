package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC150EvalReversePolishNotation {

    public int evalRPN (String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = Arrays.asList("+", "-", "*", "/");

        for (String s : tokens) {
            if (!operators.contains(s)) {
                stack.push(Integer.valueOf(s));
            }
            else {
                int val1 = stack.peek();
                stack.pop();
                int val2 = stack.peek();
                stack.pop();
                stack.push(evaluate(val1, val2, s));
            }
        }
        return stack.pop();
    }

    private int evaluate (int val1, int val2, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = val2 + val1;
                break;
            case "-":
                res = val2 - val1;
                break;
            case "*":
                res = val2 * val1;
                break;
            case "/":
                res = val2 / val1;
                break;
        }
        return res;
    }

    public static void main (String[] args) {
        LC150EvalReversePolishNotation lc150EvalReversePolishNotation = new LC150EvalReversePolishNotation();
//        System.out.println(lc150EvalReversePolishNotation.evalRPN(new String[]{"2","1","+","3","*"}));
//        System.out.println(lc150EvalReversePolishNotation.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(lc150EvalReversePolishNotation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
