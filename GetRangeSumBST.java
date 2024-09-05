public class GetRangeSumBST {
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
     * Optimized version:
     * 1) Traverse only the parts which lie in the range
     * 2) if curr node is in range continue with left and right
     * 3) if curr node is bigger than high then go left
     * 4) if curr node is less than low then go right
     */
    static int helper(BinaryTreeNode curr, int low, int high) {
        if (curr == null)
            return 0;

        // if it's in range
        if (curr.value >= low && curr.value <= high)
            return curr.value + helper(curr.left, low, high) + helper(curr.right, low, high);

        else if (curr.value < low)
            return helper(curr.right, low, high);

        else
            return helper(curr.left, low, high);
    }

    static Integer get_range_sum(BinaryTreeNode root, Integer low, Integer high) {
        return helper(root, low, high);
    }

}
