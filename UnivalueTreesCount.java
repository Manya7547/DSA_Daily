public class UnivalueTreesCount {

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

    static int count = 0;

    static Integer find_single_value_trees(BinaryTreeNode root) {
        // DFS
        if (root == null)
            return 0;
        helper(root);
        return count;
    }

    static Boolean helper(BinaryTreeNode node) {
        // if the a tree is empty, it is a univalue tree by default
        if (node == null)
            return true;
        Boolean leftSubTree = helper(node.left);
        Boolean rightSubTree = helper(node.right);

        // check if left node is null or left node value is equal to curr value and
        // right node is null or right node value is equal to curr value
        if ((node.left == null || (leftSubTree && node.left.value.equals(node.value)))
                && (node.right == null || (rightSubTree && node.right.value.equals(node.value)))) {
            count++;
            return true;
        } else {
            return false;
        }
    }

}
