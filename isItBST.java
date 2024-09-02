public class isItBST {

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

    static Boolean is_bst(BinaryTreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isbst(root, min, max);
    }

    static boolean isbst(BinaryTreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value < min || node.value > max) {
            return false;
        }
        return isbst(node.left, min, node.value) && isbst(node.right, node.value, max);
    }

}
