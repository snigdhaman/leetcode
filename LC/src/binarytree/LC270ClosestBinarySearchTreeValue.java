package binarytree;

public class LC270ClosestBinarySearchTreeValue {
    double minDiff = Integer.MAX_VALUE;
    int closestVal = 0;
    public int closestValue (TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        closestVal = root.val;
        traverse(root, target);
        return closestVal;
    }

    void traverse (TreeNode node, double target) {
        if (node == null) {
            return;
        }
        traverse(node.left, target);
        if (Math.abs(((double) node.val) - target) < minDiff) {
            minDiff = Math.abs(((double) node.val) - target);
            closestVal = node.val;
        }
        traverse(node.right, target);
    }
}
