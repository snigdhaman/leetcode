package binarytree;

import java.util.*;

public class LC236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        //Base cases: Root is null then return null
        if (root == null)
            return null;

        //If root is p or q then return the root node since target is found
        if (root == p || root == q)
            return root;

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        //This means that 1 target node is located in the left sub tree
        // and another target node is located in the right sub tree
        if (leftTree != null && rightTree != null)
            return root;

        //This means that both target nodes are located either in left
        //or right subtree
        return leftTree != null ? leftTree : rightTree;
    }

//    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
//        Map<TreeNode, TreeNode> parentNode = new HashMap<>();
//        Stack<TreeNode> dfsStack = new Stack<>();
//        dfsStack.push(root);
//        parentNode.put(root, null);
//        while (!dfsStack.isEmpty()) {
//            TreeNode node = dfsStack.pop();
//            if (node.right != null) {
//                dfsStack.push(node.right);
//                parentNode.put(node.right, node);
//            }
//            if (node.left != null) {
//                dfsStack.push(node.left);
//                parentNode.put(node.left, node);
//            }
//        }
//        Set<TreeNode> ancestorsForP = new HashSet<>();
//        TreeNode ancestor = p;
//        while (ancestor != null) {
//            ancestorsForP.add(ancestor);
//            ancestor = parentNode.get(ancestor);
//        }
//        TreeNode ancestorQ = q;
//        while (ancestorQ != null) {
//            if (ancestorsForP.contains(ancestorQ)) {
//                return ancestorQ;
//            }
//            ancestorQ = parentNode.get(ancestorQ);
//        }
//        return null;
//    }

    public static void main (String[] args) {

    }
}
