import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PreorderTraversaltoBST {

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
     * preorder: 2, 0, 1, 3, 5, 4
     * inorder: 0, 1, 2, 3, 4, 5
     */
    static BinaryTreeNode helper(int lowP, int highP, ArrayList<Integer> preorder, int lowI, int highI) {

        // if lowP > highP
        if (lowP > highP) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(preorder.get(lowP));

        // search index of root in inorder map
        int rootindex = map.get(root.value);
        int numleft = rootindex - lowI;
        int numright = highI - rootindex;

        root.left = helper(lowP + 1, lowP + numleft, preorder, lowI, rootindex - 1);
        root.right = helper(lowP + numleft + 1, highP, preorder, rootindex + 1, highI);

        return root;
    }

    static Map<Integer, Integer> map = new HashMap<>();

    static BinaryTreeNode build_binary_search_tree(ArrayList<Integer> preorder) {
        ArrayList<Integer> inorder = new ArrayList<>(preorder);
        Collections.sort(inorder);

        // saving value and it's index
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }

        return helper(0, preorder.size() - 1, preorder, 0, inorder.size() - 1);
    }

}
