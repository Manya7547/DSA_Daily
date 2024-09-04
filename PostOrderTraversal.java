import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

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

    // https://www.youtube.com/watch?v=k21VKEM8OFY&t=270s

    /*
     * Algo:
     * 1) declare two stacks
     * 2) add root to stack1
     * 3) while(stack 1 is not empty)
     * pop the top node out and push it to stack2
     * push it's children in stack1
     * repeat
     * 4) Once stack1 is empty, pop out all the nodes in stack2 and store them in
     * arrayList
     * Time Complexity:
     * push pop in stack 1 O(2N)
     * push in stack 2 O(N)
     * final pop from stack 2 O(N)
     * 
     * So - O(2N + 2N) = O(N)
     */

    static ArrayList<Integer> postorder_traversal(BinaryTreeNode root) {
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        s1.push(root);

        ArrayList<Integer> ans = new ArrayList<>();

        while (!s1.isEmpty()) {
            BinaryTreeNode curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }

        }

        while (!s2.isEmpty()) {
            BinaryTreeNode n = s2.pop();
            ans.add(n.value);
        }

        return ans;
    }

}
