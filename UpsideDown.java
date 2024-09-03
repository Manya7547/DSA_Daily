public class UpsideDown {

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

    static BinaryTreeNode flip_upside_down(BinaryTreeNode root) {
        return helper(root);
    }

    static BinaryTreeNode helper(BinaryTreeNode node) {
        // base case: node is null or leaf node
        if (node == null || node.left == null && node.right == null) {
            return node;
        }

        BinaryTreeNode new_root = helper(node.left);
        node.left.left = node.right;
        node.left.right = node;
        node.left = null;
        node.right = null;

        return new_root;
    }

    /*
     * start changing the pointers of the left child node from bottom up
     * save the new_root which is the leftmost node.
     * 
     * 
     */

}
