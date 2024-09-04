import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

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

    // Helper class going to be used int queue for Level order traversal
    static class Pair {
        BinaryTreeNode node;
        int index;

        Pair(BinaryTreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static Integer find_maximum_width(BinaryTreeNode root) {
        // if root is null max width is 0
        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int index = p.index;
                BinaryTreeNode currNode = p.node;

                if (i == 0) {
                    first = index;
                }
                if (i == size - 1) {
                    last = index;
                }

                if (currNode.left != null) {
                    q.add(new Pair(currNode.left, index * 2 + 1));
                }
                if (currNode.right != null) {
                    q.add(new Pair(currNode.right, index * 2 + 2));
                }

            }

            result = Math.max(result, last - first + 1);
        }
        return result;
    }

}
