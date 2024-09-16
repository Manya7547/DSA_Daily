import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindNodesAtDistanceK {

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
     * 1) Make a child -> parent map after doing DFS
     * 2) Do BFS to get the nodes at a distance of k
     */

    static void findNodes(BinaryTreeNode root, int target_node, int distance, Map<BinaryTreeNode, BinaryTreeNode> map) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode target = null;

        for (BinaryTreeNode x : map.keySet()) {
            if (x.value == target_node) {
                target = x;
                break;
            }
        }

        if (target == null)
            return;

        q.add(target);

        if (distance == 0) {
            ans.add(target.value);
            return;
        }

        Set<BinaryTreeNode> visited = new HashSet<>();
        visited.add(target);

        while (distance > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode curr = q.poll();
                if (curr.left != null && visited.add(curr.left))
                    q.add(curr.left);
                if (curr.right != null && visited.add(curr.right))
                    q.add(curr.right);
                if (map.containsKey(curr) && map.get(curr) != null && visited.add(map.get(curr))) {
                    q.add(map.get(curr));
                }
            }
            distance--;
        }

        int size = q.size();
        while (!q.isEmpty()) {
            ans.add(q.poll().value);
        }

    }

    static void createMap(BinaryTreeNode child, BinaryTreeNode parent, Map<BinaryTreeNode, BinaryTreeNode> map) {
        if (child == null)
            return;

        map.put(child, parent);

        // new child is child.left and child.right
        // new parent is child
        createMap(child.left, child, map);
        createMap(child.right, child, map);

    }

    static ArrayList<Integer> ans = new ArrayList<>();

    static ArrayList<Integer> nodes_at_given_distance(BinaryTreeNode root, Integer target_node, Integer distance) {
        Map<BinaryTreeNode, BinaryTreeNode> map = new HashMap<>();
        createMap(root, null, map);
        findNodes(root, target_node, distance, map);
        return ans;
    }

}
