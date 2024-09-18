public class DiameterOfABinaryTree {

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
     * Diameter of a binary tree is the distance between any two nodes counted using
     * edges and not nodes.
     * The diameter may or may not pass through the root node
     * Algorithm:
     * 1) for every node find outits diameter -> height of left subtree + height of
     * right subtree + 2
     * 2) maintain a global diameter which is the max diameter
     * 3) return max height of the tree
     * 
     */

    static int globalDiameter;

    static int findDiameter(BinaryTreeNode root) {

        // if leaf node then it does ot have a height
        if (root.left == null && root.right == null)
            return 0;

        int LH = 0;
        int RH = 0;
        int myDia = 0;

        // capture left height and add 1
        if (root.left != null) {
            LH = findDiameter(root.left);
            myDia = LH + 1;
        }

        // capture right height and add 1
        if (root.right != null) {
            RH = findDiameter(root.right);
            myDia += RH + 1;
        }

        globalDiameter = Math.max(globalDiameter, myDia);

        // return the max height of the tree rooted at that current node
        return Math.max(LH, RH) + 1;

    }

    static Integer binary_tree_diameter(BinaryTreeNode root) {
        globalDiameter = 0;
        findDiameter(root);
        return globalDiameter;
    }

}
