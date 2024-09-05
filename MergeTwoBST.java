import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST {
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
     * 1) convert tree1 and tree2 into Lists<BinaryTreeNode> - in order traversal so
     * they both are in sorted order
     * 2) merge them together in sorted order - 2 pointer method
     * 3) convert this array into a Binary Search Tree
     */

    static void inorder(BinaryTreeNode root, List<BinaryTreeNode> inorderList) {
        if (root == null) {
            return;
        }

        // in order traversal of the BST
        inorder(root.left, inorderList);
        inorderList.add(root);
        inorder(root.right, inorderList);
    }

    static BinaryTreeNode balancedBST(List<BinaryTreeNode> merged, int low, int high) {

        if (low > high)
            return null;

        if (low == high)
            return merged.get(low);

        // root
        int mid = (low + high) / 2;

        merged.get(mid).left = balancedBST(merged, low, mid - 1);
        merged.get(mid).right = balancedBST(merged, mid + 1, high);

        return merged.get(mid);
    }

    static BinaryTreeNode merge_two_binary_search_trees(BinaryTreeNode root1, BinaryTreeNode root2) {
        List<BinaryTreeNode> inorder1 = new ArrayList<>();
        List<BinaryTreeNode> inorder2 = new ArrayList<>();

        inorder(root1, inorder1);
        inorder(root2, inorder2);

        // merge the two lists using 2 pointer method
        List<BinaryTreeNode> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < inorder1.size() && j < inorder2.size()) {
            if (inorder1.get(i).value < inorder2.get(j).value) {
                merged.add(inorder1.get(i));
                i++;
            } else {
                merged.add(inorder2.get(j));
                j++;
            }
        }

        // gather phase
        while (i < inorder1.size()) {
            merged.add(inorder1.get(i));
            i++;
        }

        while (j < inorder2.size()) {
            merged.add(inorder2.get(j));
            j++;
        }

        // break all pointers to the child nodes

        for (BinaryTreeNode node : merged) {
            node.left = null;
            node.right = null;
        }

        return balancedBST(merged, 0, merged.size() - 1);
    }

}
