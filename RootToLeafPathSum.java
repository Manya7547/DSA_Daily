public class RootToLeafPathSum {

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

    static boolean bool = false;

    static void helper(BinaryTreeNode root, long sum, int k) {
        // base case
        if (root == null)
            return;

        if (root.left == null && root.right == null) {

            if (sum == (long) (k - root.value)) {
                bool = true;
                return;
            }
        }

        helper(root.left, sum + root.value, k);
        helper(root.right, sum + root.value, k);

    }

    static Boolean path_sum(BinaryTreeNode root, Integer k) {
        helper(root, 0, k);
        return bool;
    }

}
