package binarytree;

import java.util.Stack;

public class LC173BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public LC173BinarySearchTreeIterator (TreeNode root) {
        stack = new Stack<>();
        TreeNode currNode = root;
        //Push all nodes as far left as we can go
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        //If node has right child then push all children as far as left as you can go
        TreeNode currNode = node.right;
        while (currNode != null) {
            stack.push(currNode);
            currNode = currNode.left;
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
