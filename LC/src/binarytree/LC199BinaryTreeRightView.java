package binarytree;

import java.util.*;

public class LC199BinaryTreeRightView {

    public List<Integer> rightSideView (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> dfsStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        dfsStack.push(root);
        depthStack.push(0);
        while (!dfsStack.isEmpty()) {
            TreeNode nd = dfsStack.pop();
            int currDepth = depthStack.pop();
            map.put(currDepth, nd.val);
            if (nd.right != null) {
                dfsStack.push(nd.right);
                depthStack.push(currDepth + 1);
            }
            if (nd.left != null) {
                dfsStack.push(nd.left);
                depthStack.push(currDepth + 1);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main (String[] args) {
        LC199BinaryTreeRightView lc199BinaryTreeRightView = new LC199BinaryTreeRightView();
    }
}
