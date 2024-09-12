public class DistributeCoinsinaBinaryTree {
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
     * 1) at each node, return [size of subtree and number of coins]
     * 2) global variable res will keep track of the number of moves counted using
     * the number of absolute extra coins
     */

    static int res;

    static class NodeInfo {
        int size;
        int coins;

        NodeInfo() {
            this.size = 0;
            this.coins = 0;
        }
    }

    static NodeInfo helper(BinaryTreeNode root) {

        NodeInfo curr = new NodeInfo();

        // base case
        if (root == null) {
            return curr;
        }

        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);

        curr.size = left.size + right.size + 1;
        curr.coins = left.coins + right.coins + root.value;

        res = res + Math.abs(curr.coins - curr.size);

        return curr;
    }

    static Integer get_minimum_moves(BinaryTreeNode root) {
        res = 0;
        NodeInfo info = helper(root);
        return res;
    }

}
