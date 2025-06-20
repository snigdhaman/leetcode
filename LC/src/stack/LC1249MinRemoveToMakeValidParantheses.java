package stack;

import java.util.Stack;

public class LC1249MinRemoveToMakeValidParantheses {

    public String minRemoveToMakeValid (String s) {
        Stack<Character> parStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int index = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                parStack.push(ch);
                indexStack.push(index);
            }
            if (ch == ')') {
                if (!parStack.isEmpty() && parStack.peek() == '(') {
                    parStack.pop();
                    indexStack.pop();
                }
                else {
                    parStack.push(')');
                    indexStack.push(index);
                }
            }
            index++;
        }
        while (!indexStack.isEmpty()) {
            int idx = indexStack.peek();
            s = s.substring(0, idx) + s.substring(idx + 1);
            indexStack.pop();
        }
        return s;
    }

    public static void main(String[] args) {
        LC1249MinRemoveToMakeValidParantheses lc1249MinRemoveToMakeValidParantheses = new LC1249MinRemoveToMakeValidParantheses();
        System.out.println(lc1249MinRemoveToMakeValidParantheses.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(lc1249MinRemoveToMakeValidParantheses.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(lc1249MinRemoveToMakeValidParantheses.minRemoveToMakeValid("))(("));
    }
}
