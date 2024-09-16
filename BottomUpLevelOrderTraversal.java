import java.util.ArrayList;
import java.util.Collections;

public class BottomUpLevelOrderTraversal {
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
     * 1) DFS
     * 2) Store the node value at the level i which is the index of list of list
     * 3) reverse the list of list in the end
     */

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static void helper(BinaryTreeNode root, int level) {
        if (root == null)
            return;

        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.value);

        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }

    static ArrayList<ArrayList<Integer>> reverse_level_order_traversal(BinaryTreeNode root) {
        helper(root, 0);
        Collections.reverse(ans);
        return ans;
    }

}
