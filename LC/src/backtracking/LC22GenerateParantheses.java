package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParantheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis (int n) {
        backTrack("", 0, 0, n);
        return res;
    }

    public void backTrack (String str, int openCount, int closedCount, int n) {
        if (openCount == closedCount && openCount == n) {
            res.add(str);
            return;
        }
        if (openCount < n) {
            str = str + "(";
            backTrack(str, openCount + 1, closedCount, n);
            str = str.substring(0, str.length() - 1);
        }
        if (closedCount < openCount) {
            str = str + ")";
            backTrack(str, openCount, closedCount + 1, n);
            str = str.substring(0, str.length() - 1);
        }
    }

    public static void main(String[] args) {
        LC22GenerateParantheses lc22GenerateParantheses = new LC22GenerateParantheses();
        System.out.println(lc22GenerateParantheses.generateParenthesis(3));
    }
}
