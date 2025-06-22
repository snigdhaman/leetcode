package graph;

import binarytree.TreeNode;

import java.util.*;

public class LC863AllNodesInDistK {
    Map<TreeNode, TreeNode> parentMap;
    List<Integer> res;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();
        res = new ArrayList<>();
        prepareParentMap(root, target);
        // for (TreeNode node : parentMap.keySet()) {
        //     System.out.println("Child :: " + node.val + " :: Parent :: " + parentMap.get(node).val);
        // }
        return bfs(target, k);
    }

    /** Prepares the parent map
     */
    void prepareParentMap (TreeNode node, TreeNode target) {
        if (node.left != null) {
            parentMap.put(node.left, node);
            prepareParentMap(node.left, target);
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            prepareParentMap(node.right, target);
        }
    }

    List<Integer> bfs (TreeNode target, int k) {
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        bfsQueue.offer(target);
        visited.add(target);
        Map<TreeNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(target, 0);
        while (!bfsQueue.isEmpty()) {
            TreeNode node = bfsQueue.poll();
            visited.add(node);
            // System.out.println("Node to be removed :: " + node.val);
            if (node.left != null && !visited.contains(node.left)) {
                bfsQueue.offer(node.left);
                distanceMap.put(node.left, distanceMap.get(node) + 1);
            }
            if (node.right != null && !visited.contains(node.right)) {
                bfsQueue.offer(node.right);
                distanceMap.put(node.right, distanceMap.get(node) + 1);
            }
            if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                bfsQueue.offer(parentMap.get(node));
                distanceMap.put(parentMap.get(node), distanceMap.get(node) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (TreeNode n : distanceMap.keySet()) {
            if (distanceMap.get(n) == k)
                res.add(n.val);
        }
        return res;
    }
}
