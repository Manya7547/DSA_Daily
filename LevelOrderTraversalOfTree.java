import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversalOfTree {

    class TreeNode {
        Integer value;
        ArrayList<TreeNode> children;

        TreeNode(Integer value) {
            this.value = value;
            this.children = new ArrayList(3);
        }
    }

    static ArrayList<ArrayList<Integer>> level_order(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> slate = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                slate.add(curr.value);
                for (TreeNode child : curr.children) {
                    q.add(child);
                }
            }
            ans.add(slate);
        }
        return ans;
    }

}
