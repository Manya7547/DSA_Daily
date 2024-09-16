import java.util.ArrayList;

public class PreOrderTraversal {

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

    static ArrayList<Integer> ans = new ArrayList<>();

    static void helper(BinaryTreeNode root) {
        if (root == null)
            return;

        ans.add(root.value);

        helper(root.left);
        helper(root.right);
    }

    static ArrayList<Integer> preorder(BinaryTreeNode root) {
        helper(root);
        return ans;
    }

}
