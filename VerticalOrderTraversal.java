import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
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

    // pair of node and it's distance(from the root)
    static class Pair {
        int distance;
        BinaryTreeNode node;

        Pair(BinaryTreeNode node, int distance) {
            this.distance = distance;
            this.node = node;
        }
    }

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> vertical_order_traversal(BinaryTreeNode root) {
        if (root == null) {
            return ans;
        }

        // It automatically orders the mapping according to the natural ordering of it's
        // keys
        // storing distance from root and list of nodes's values in this
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        // BFS
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            BinaryTreeNode curr = p.node;
            int distance = p.distance;

            // store it in the tree map. K is distance and value is the arraylist
            if (!map.containsKey(distance)) {
                map.put(distance, new ArrayList<>());
            }

            map.get(distance).add(curr.value);

            if (curr.left != null) {
                q.add(new Pair(curr.left, distance - 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, distance + 1));
            }
        }
        for (ArrayList<Integer> entry : map.values()) {
            ans.add(entry);
        }

        return ans;
    }

}
