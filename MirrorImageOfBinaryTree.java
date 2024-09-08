public class MirrorImageOfBinaryTree {
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

    /*
     * Algorithm:
     * 1) at each node I want to exchange the position of the left and right
     * children
     */

    static void helper(BinaryTreeNode node) {

        if (node == null)
            return;

        BinaryTreeNode x = node.left;
        node.left = node.right;
        node.right = x;

        helper(node.left);
        helper(node.right);

    }

    static void mirror_image(BinaryTreeNode root) {
        helper(root);
    }

}
