package stack;

import java.util.Stack;

public class LC71SimplifyPath {

    public String simplifyPath (String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) continue;
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else stack.push(token);
        }

        StringBuilder res = new StringBuilder();
        for (String token : stack) {
            res.append("/");
            res.append(token);
        }
        return res.length() > 0 ? res.toString() : "/";
    }

    public static void main (String[] args) {
        LC71SimplifyPath lc71SimplifyPath = new LC71SimplifyPath();
        System.out.println(lc71SimplifyPath.simplifyPath("/home/"));
        System.out.println(lc71SimplifyPath.simplifyPath("/home//foo/"));
        System.out.println(lc71SimplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(lc71SimplifyPath.simplifyPath("/../"));
        System.out.println(lc71SimplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
    }
}
