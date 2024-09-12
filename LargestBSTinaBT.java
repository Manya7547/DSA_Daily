public class LargestBSTinaBT {

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

    static class NodeInfo {
        int min; // from right sub tree
        int max; // from left subtree
        boolean isBST; // tree rooted at curr is BST or not
        int size; // if BST then what size
        int maxSize; // max size up until now

        NodeInfo() {
            this.min = Integer.MIN_VALUE;
            this.max = Integer.MAX_VALUE;
            this.isBST = true; // an empty tree is a bst by default
            this.size = 0;
            this.maxSize = 0;
        }
    }

    static NodeInfo helper(BinaryTreeNode root) {
        // initializing an object of current node
        NodeInfo curr = new NodeInfo();

        // if root is null, return from there
        if (root == null)
            return curr;

        // if leaf node
        if (root.left == null && root.right == null) {
            curr.isBST = true;
            curr.min = root.value;
            curr.max = root.value;
            curr.size = 1;
            curr.isBST = true;
            curr.maxSize = 1;
        }

        // left node is null
        else if (root.left == null) {
            NodeInfo right = helper(root.right);
            // if right is a BST and root value is less than min
            if (right.isBST && root.value <= right.min) {
                curr.isBST = true;
                curr.min = root.value;
                curr.max = right.max;
                curr.size = right.size + 1;
                curr.maxSize = Math.max(curr.size, right.maxSize);
            } else {
                curr.isBST = false;
                curr.maxSize = right.maxSize;
            }
        }

        // right node is null
        else if (root.right == null) {
            NodeInfo left = helper(root.left);
            if (left.isBST && left.max <= root.value) {
                curr.isBST = true;
                curr.size = left.size + 1;
                curr.maxSize = Math.max(curr.size, left.size);
                curr.min = left.min;
                curr.max = root.value;
            } else {
                curr.isBST = false;
                curr.maxSize = left.maxSize;
            }
        }

        // both the children are present
        else {
            NodeInfo left = helper(root.left);
            NodeInfo right = helper(root.right);
            if (left.isBST && right.isBST && left.max <= root.value && root.value <= right.min) {
                curr.isBST = true;
                curr.size = right.size + left.size + 1;
                curr.maxSize = Math.max(curr.size, Math.max(left.maxSize, right.maxSize));
                curr.min = left.min;
                curr.max = right.max;
            } else {
                curr.isBST = false;
                curr.maxSize = Math.max(left.maxSize, right.maxSize);
            }
        }

        return curr;
    }

    static Integer find_largest_bst(BinaryTreeNode root) {
        if (root == null)
            return 0;
        NodeInfo ans = helper(root);
        return ans.maxSize;
    }

}
