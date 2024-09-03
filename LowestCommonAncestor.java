public class LowestCommonAncestor {
    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    BinaryTreeNode ans;

    static Integer lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode lcaNode = helper(root, a, b);
        return lcaNode.value;
    }

    static BinaryTreeNode helper(BinaryTreeNode node, BinaryTreeNode a, BinaryTreeNode b) {

        // base condition
        if (node == null || node == a || node == b) {
            return node;
        }
        // recursive - DFS
        // Either we find the a and b or they return null
        BinaryTreeNode left = helper(node.left, a, b);
        BinaryTreeNode right = helper(node.right, a, b);

        // operation after recursion - bottom up
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        // whenn we reach a node where both the subtrees have a non null value that
        // means node is the LCA
        else {
            return node;
        }

    }

}
