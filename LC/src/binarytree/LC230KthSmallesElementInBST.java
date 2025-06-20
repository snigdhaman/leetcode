package binarytree;

import java.util.Stack;

public class LC230KthSmallesElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> inorderStack = new Stack<>();
        TreeNode currNode = root;
        int count = 0;
        //Continue till stack is not empty or count < k
        while (!inorderStack.isEmpty() || count < k) {
            //Go as fas left as possible & push to stack
            while (currNode != null) {
                inorderStack.push(currNode);
                currNode = currNode.left;
            }
            //Pop stack.pop()
            TreeNode node = inorderStack.pop();
            count++;
            if (count == k) {
                return node.val;
            }
            //If node has right subtree then go as far left of
            //right subtree as possible
            TreeNode rightNode = node.right;
            while (rightNode != null) {
                inorderStack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return 0;
    }
}
