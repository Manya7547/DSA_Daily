import java.util.ArrayList;
import java.util.PriorityQueue;

public class ClosestValuesinBST {

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
     * Algorithm:
     * 1) Max heap size k <Node, difference> - difference between target value and
     * node
     * 2) traverse through the whole tree
     */

    static class Pair {
        BinaryTreeNode node;
        int diff;

        Pair(BinaryTreeNode node, int diff) {
            this.node = node;
            this.diff = diff;
        }
    }

    // max heap
    static PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> b.diff - a.diff);

    static void helper(BinaryTreeNode root, int target, int k) {
        if (root == null)
            return;

        helper(root.left, target, k);
        q.add(new Pair(root, Math.abs(root.value - target)));
        if (q.size() > k)
            q.poll();
        helper(root.right, target, k);
    }

    static ArrayList<Integer> find_k_closest_values(BinaryTreeNode root, Integer target, Integer k) {

        helper(root, target, k);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().node.value);
        }
        return ans;
    }
}
