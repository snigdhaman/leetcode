package binarytree;

public class LC129SumRootToLeaf {

    int res = 0;
    public int sumNumbers (TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs (TreeNode node, int currPathSum) {
        if (node != null) {
            currPathSum = (currPathSum * 10) + node.val;
            if (node.left == null && node.right == null) {
                res += currPathSum;
            }
            dfs(node.left, currPathSum);
            dfs(node.right, currPathSum);
        }
    }

    public static void main(String[] args) {
        LC129SumRootToLeaf lc129SumRootToLeaf = new LC129SumRootToLeaf();
        TreeNode r = new TreeNode(4);
        TreeNode n9 = new TreeNode(9);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n0 = new TreeNode(0);

        r.left = n9;
        n9.left = n5;
        n9.right = n1;
        r.right = n0;

        System.out.println(lc129SumRootToLeaf.sumNumbers(r));
    }

}
