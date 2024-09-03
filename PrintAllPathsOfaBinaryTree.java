import java.util.ArrayList;

public class PrintAllPathsOfaBinaryTree {
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

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> all_paths_of_a_binary_tree(BinaryTreeNode root) {
        ArrayList<Integer> slate = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, slate);
        return ans;
    }

    static void helper(BinaryTreeNode node, ArrayList<Integer> slate) {
        // base case
        if (node.left == null && node.right == null) {
            slate.add(node.value);
            ans.add(new ArrayList<>(slate));
            slate.remove(slate.size() - 1);
            return;
        }

        // recursive case
        slate.add(node.value);
        if (node.left != null)
            helper(node.left, slate);
        if (node.right != null)
            helper(node.right, slate);
        slate.remove(slate.size() - 1);

    }

}
