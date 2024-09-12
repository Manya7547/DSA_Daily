import java.util.ArrayList;
import java.util.HashMap;

public class ConstructABinaryTree {

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

    static int curr = 0;

    static BinaryTreeNode helper(int start, int end, HashMap<Integer, Integer> inorder_map,
            ArrayList<Integer> preorder) {
        // base case
        if (start > end) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(preorder.get(curr++));

        if (start == end) {
            return root;
        }

        int rootIndex = inorder_map.get(root.value);

        root.left = helper(start, rootIndex - 1, inorder_map, preorder);
        root.right = helper(rootIndex + 1, end, inorder_map, preorder);

        return root;
    }

    static BinaryTreeNode construct_binary_tree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        HashMap<Integer, Integer> inorder_map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            inorder_map.put(inorder.get(i), i);
        }

        return helper(0, preorder.size() - 1, inorder_map, preorder);
    }

}
