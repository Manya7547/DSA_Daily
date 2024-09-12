import java.util.LinkedList;
import java.util.Queue;

public class PopulateSiblingPointer {

    class BinaryTreeNode {
        Integer value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode next_right;

        BinaryTreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.next_right = null;
        }
    }

    /*
     * 1) Using level order traversal to process each node at the same level
     * 2) Each node at the same level will point to the adjacent node at the same
     * level
     */
    static BinaryTreeNode populate_sibling_pointers(BinaryTreeNode root) {
        if (root == null)
            return root;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            BinaryTreeNode prev = null;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode curr = q.poll();

                if (prev != null) {
                    prev.next_right = curr;
                }
                prev = curr;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);

                }
            }

            // last node of each level should point to null
            if (prev != null) {
                prev.next_right = null;
            }

        }
        return root;
    }

}
