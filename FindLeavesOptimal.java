import java.util.ArrayList;

public class FindLeavesOptimal {
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
     * Algo:
     * 1) call recursive function(root, list of list )
     * 2) recursive function(){
     * base case - if node is null then return 0 - height is 0
     * 
     * height is the height of a node from the bottom
     * height = Maximum of the left subtree and right subtree height
     * 
     * new height is introduced
     * if(size of list == height - 1) {
     * list . add new list
     * }
     * 
     * list.get(height-1).add(node value)
     * 
     * return height;
     * 
     * }
     */
    static int helper(BinaryTreeNode root, ArrayList<ArrayList<Integer>> leaves) {

        // base case:
        if (root == null)
            return 0;

        // determine height for each node from the bottom
        int height = Math.max(helper(root.left, leaves), helper(root.right, leaves)) + 1;

        // if height's index does not exist in the list
        if (height - 1 == leaves.size()) {
            leaves.add(new ArrayList<>());
        }

        leaves.get(height - 1).add(root.value);

        return height;
    }

    static ArrayList<ArrayList<Integer>> find_leaves(BinaryTreeNode root) {

        ArrayList<ArrayList<Integer>> leaves = new ArrayList<>();
        helper(root, leaves);
        return leaves;
    }

}
