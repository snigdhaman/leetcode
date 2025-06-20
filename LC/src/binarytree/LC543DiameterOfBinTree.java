package binarytree;

public class LC543DiameterOfBinTree {
    
//    public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//    }

    int diameter;

    public int diameterOfBinaryTree (TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

//    private int getDiameter (TreeNode node, int currDepth) {
//        int res = 0;
//        if (node.left != null) {
//            res += getDiameter(node.left, currDepth + 1);
//        }
//        if (node.right != null) {
//            res += getDiameter(node.right, currDepth + 1);
//        }
//        maxDiameter = Math.max(maxDiameter, res);
//        return currDepth;
//    }

    int dfs (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return 1 + Math.max(leftPath, rightPath);
    }

    public static void main (String[] args) {
        LC543DiameterOfBinTree lc543DiameterOfBinTree = new LC543DiameterOfBinTree();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2l1 = new TreeNode(4);
        TreeNode l2r1 = new TreeNode(5);
        root.left = l1;
        l1.left = l2l1;
        l1.right = l2r1;
        root.right = r1;

        System.out.println(lc543DiameterOfBinTree.diameterOfBinaryTree(root));

    }

}
