package binarytree;

public class LC235LowestCommonAncestorBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currNode = root;
        while (currNode != null) {
            if (p.val < currNode.val && q.val < currNode.val)
                currNode = currNode.left;
            else if (p.val > currNode.val && q.val > currNode.val)
                currNode = currNode.right;
            else
                return currNode;
        }
        return root;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //Base cases: Root is null then return null
//        if (root == null)
//            return null;
//
//        //If root is p or q then return the root node since target is found
//        if (root == p || root == q)
//            return root;
//
//        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
//        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
//
//        //This means that 1 target node is located in the left sub tree
//        // and another target node is located in the right sub tree
//        if (leftTree != null && rightTree != null)
//            return root;
//
//        //This means that both target nodes are located either in left
//        //or right subtree
//        return leftTree != null ? leftTree : rightTree;
//    }
}
