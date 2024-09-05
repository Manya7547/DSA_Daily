public class HeightBalanced {
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
     * 1) Use recursive approach
     * 2) for every node check if it's null the return 0
     * 3) For every node check leftheight = helper(left) and right height
     * =helper(right)
     * 4) for everynode check if leftheight = -1 or right height -1 or diff(left -
     * right) > 1 then return -1
     * 5) return height of the current sub tree - Math.max(left, right) + 1
     */

    static int helper(BinaryTreeNode curr) {
        if (curr == null)
            return 0;

        int leftHeight = helper(curr.left);
        int rightHeight = helper(curr.right);

        // if one of the heights is -1 then return -1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // return the height
        return Math.max(leftHeight, rightHeight) + 1;

    }

    static Boolean is_height_balanced(BinaryTreeNode root) {
        return helper(root) != -1;
    }

}
