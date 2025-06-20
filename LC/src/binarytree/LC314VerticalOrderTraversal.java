package binarytree;

import java.util.*;
import java.util.stream.Collectors;

public class LC314VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder (TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        Queue<Integer> colIndexQueue = new LinkedList<>();

        bfsQueue.offer(root);
        colIndexQueue.offer(0);
        while (!bfsQueue.isEmpty()) {
            TreeNode currNode = bfsQueue.poll();
            int currColIndex = colIndexQueue.poll();
            List<Integer> list;
            if (!map.containsKey(currColIndex)) list = new ArrayList<>();
            else list = map.get(currColIndex);

            list.add(currNode.val);
            map.put(currColIndex, list);

            if (currNode.left != null) {
                bfsQueue.offer(currNode.left);
                colIndexQueue.offer(currColIndex - 1);
            }
            if (currNode.right != null) {
                bfsQueue.offer(currNode.right);
                colIndexQueue.offer(currColIndex + 1);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        List<List<Integer>> res = new ArrayList<>();
        for (int n : keySet) {
            res.add(map.get(n));
        }
        return res;
    }

    public static void main(String[] args) {
        LC314VerticalOrderTraversal lc314VerticalOrderTraversal = new LC314VerticalOrderTraversal();
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(4);
        TreeNode rl2 = new TreeNode(0);
        l1.left = l2;
        l1.right = rl2;
        TreeNode lr2 = new TreeNode(1);
        TreeNode r2 = new TreeNode(7);
        r1.left = lr2;
        r1.right = r2;

        System.out.println(lc314VerticalOrderTraversal.verticalOrder(root));

    }

}
