public class CountNodes {

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

    static Integer count_nodes(BinaryTreeNode root) {
        return helper(root);
    }

    static int helper(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        return left + right + 1;
    }

}
