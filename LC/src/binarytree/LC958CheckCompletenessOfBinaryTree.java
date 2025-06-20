package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LC958CheckCompletenessOfBinaryTree {
    boolean nullEncountered = false;
    public boolean isCompleteTree (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return bfs(queue);
    }

    boolean bfs (Queue<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null && !nullEncountered) {
                nullEncountered = true;
                continue;
            }
            if (node != null) {
                if (nullEncountered) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
