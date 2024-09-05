import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToCircularDLL {
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

    // Algo
    // make a list of in order traversal of the bst
    // remove the links
    // then connect the nodes in a doubly linked list and return root

    static void convertInorder(BinaryTreeNode root, List<BinaryTreeNode> inorder) {

        if (root == null)
            return;

        // in order traversal
        convertInorder(root.left, inorder);
        inorder.add(root);
        convertInorder(root.right, inorder);
    }

    static BinaryTreeNode binary_tree_to_cdll(BinaryTreeNode root) {

        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        List<BinaryTreeNode> inorder = new ArrayList<>();
        convertInorder(root, inorder);

        // to be returned in the end
        BinaryTreeNode root2 = inorder.get(0);

        // remove all links
        for (BinaryTreeNode node : inorder) {
            node.left = null;
            node.right = null;
        }

        BinaryTreeNode curr = root2;

        for (int i = 1; i < inorder.size() - 1; i++) {
            inorder.get(i).right = inorder.get(i + 1);
            inorder.get(i).left = inorder.get(i - 1);
        }

        inorder.get(0).left = inorder.get(inorder.size() - 1);
        inorder.get(0).right = inorder.get(1);
        inorder.get(inorder.size() - 1).left = inorder.get(inorder.size() - 2);
        inorder.get(inorder.size() - 1).right = inorder.get(0);

        return root2;

    }

}
