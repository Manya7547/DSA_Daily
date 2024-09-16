import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

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

    static ArrayList<ArrayList<Integer>> zigzag_level_order_traversal(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();

        q.add(root);
        Boolean even = false;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> slate = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode curr = q.poll();
                slate.add(curr.value);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            if (even) {
                Collections.reverse(slate);
            }
            even = !even;
            ans.add(slate);
        }

        return ans;
    }

}
