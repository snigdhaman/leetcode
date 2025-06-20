package binarytree;

import java.util.HashSet;
import java.util.Set;

public class LC1650LowestCommonAncestorIII {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor (Node p, Node q) {
        Set<Node> visited = new HashSet<>();
        Node node = p;
        while (node != null) {
            visited.add(node);
            node = node.parent;
        }

        Node nodeq = q;
        while (nodeq != null) {
            if (visited.contains(nodeq)) {
                return nodeq;
            }
            nodeq = nodeq.parent;
        }
        return null;
    }

    public static void main(String[] args) {
        LC1650LowestCommonAncestorIII lc1650LowestCommonAncestorIII = new LC1650LowestCommonAncestorIII();
    }
}
