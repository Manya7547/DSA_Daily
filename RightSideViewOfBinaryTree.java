import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightSideViewOfBinaryTree {

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
     * Intuition:
     * 1) level order traversal
     * 2) the last node of each level is going be be added to the final arraylist
     * 
     * Algo:
     * 1) declare an arrayList ans
     * 2) declare a queue of BinaryTreeNode
     * 3) add root into the queue
     * 4) while(q is not empty){
     * size = size of queue
     * for(i = 0 to size){
     * curr = q.poll()
     * if(i == size-1){
     * ans.add(curr.value);
     * }
     * if( left node is not null) add to queue
     * if(right node is not null) add to queue
     * }
     * }
     * 5) return ans
     * 
     */
    static ArrayList<Integer> right_view(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode curr = q.poll();
                if (i == size - 1) {
                    ans.add(curr.value);
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return ans;
    }

}
