package stack;

import java.util.Stack;

public class LC921MinAddToMakeValidParantheses {
    public int minAddToMakeValid (String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(c);
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
