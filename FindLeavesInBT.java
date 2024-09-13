import java.util.ArrayList;

public class FindLeavesInBT {

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

    // helper fn
    static void helper(BinaryTreeNode root, BinaryTreeNode parent, ArrayList<Integer> leafs) {

        // if node is null simply return
        if (root == null) {
            return;
        }

        // if leaf node found
        if (root.left == null && root.right == null) {
            leafs.add(root.value);
            // unlink from parent
            // in case of root node parent is null so that's why this check is necessary
            if (parent != null) {
                if (parent.left == root) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            return;
        }

        helper(root.left, root, leafs);
        helper(root.right, root, leafs);

    }

    static ArrayList<ArrayList<Integer>> find_leaves(BinaryTreeNode root) {
        // if empty tree
        if (root == null)
            return ans;

        ArrayList<Integer> leafs;

        // in the end only root node will remainbecause it's parent is null
        // loop will still contine even if one of the child becomes null
        while (root.left != null || root.right != null) {
            // passing root and it's parent node which is null
            leafs = new ArrayList<>();
            helper(root, null, leafs);
            ans.add(leafs);
        }

        // adding root node into ans
        leafs = new ArrayList<>();
        leafs.add(root.value);
        ans.add(leafs);

        return ans;
    }

}
