public class SymmetricBinaryTree {

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

    static Boolean check_if_symmetric(BinaryTreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    static Boolean helper(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.value.equals(root2.value)) {
            return helper(root1.left, root2.right) && helper(root1.right, root2.left);
        }

        return false;
    }

}
