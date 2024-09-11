import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeIteratorProblem {

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

    static class BinaryTreeIterator {
        private Stack<BinaryTreeNode> stack;

        BinaryTreeIterator(BinaryTreeNode root) {
            stack = new Stack<>();
            if (root != null) {
                pushLeftChildIntoStack(root);
            }
        }

        public int has_next() {
            if (!stack.isEmpty())
                return 1;
            return 0;
        }

        public int next() {
            if (!stack.isEmpty()) {
                BinaryTreeNode next = stack.pop();
                pushLeftChildIntoStack(next.right);
                return next.value;
            }
            return 0;
        }

        private void pushLeftChildIntoStack(BinaryTreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

    }

    static ArrayList<Integer> implement_tree_iterator(BinaryTreeNode root, ArrayList<String> operations) {
        ArrayList<Integer> ans = new ArrayList<>();
        BinaryTreeIterator iter = new BinaryTreeIterator(root);
        for (String op : operations) {
            if (op.equals("has_next")) {
                ans.add(iter.has_next());
            }
            if (op.equals("next")) {
                ans.add(iter.next());
            }
        }
        return ans;
    }

}
