import java.util.ArrayList;

public class PrintAllPathsThatSumTok {

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

    static void helper(BinaryTreeNode root, int k, ArrayList<Integer> slate) {
        // root is null
        if (root == null)
            return;

        // root is leaf
        if (root.left == null && root.right == null) {
            if (root.value == k) {
                slate.add(root.value);
                ans.add(new ArrayList<>(slate));
                slate.remove(slate.size() - 1);
            }
            return;
        }

        // operation
        slate.add(root.value);
        helper(root.left, k - root.value, slate);
        helper(root.right, k - root.value, slate);
        slate.remove(slate.size() - 1);
    }

    static ArrayList<ArrayList<Integer>> all_paths_sum_k(BinaryTreeNode root, Integer k) {
        ArrayList<Integer> slate = new ArrayList<>();
        helper(root, k, slate);
        if (ans.isEmpty()) {
            slate.add(-1);
            ans.add(slate);
        }
        return ans;
    }

}
