package binarytree;

public class LC938RangeSumBST {

    int sum = 0;
    public int rangeSumBST (TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    void traverse (TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        traverse(node.left, low, high);
        traverse(node.right, low, high);
    }

    public static void main (String[] args) {
        LC938RangeSumBST lc938RangeSumBST = new LC938RangeSumBST();
    }

}
