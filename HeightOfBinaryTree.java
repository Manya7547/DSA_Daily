/*
Time Complexity: O(N), because the function visits every node in the tree exactly once.
Space Complexity: The space complexity is O(H), where H is the height of the tree, 
due to the call stack used by the recursion. In the worst case (for a skewed tree), 
this could be O(N). For a balanced tree, the space complexity would be O(log N).
 */
public class HeightOfBinaryTree {

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

    static Integer height_of_binary_tree(BinaryTreeNode root) {
        return helper(root);
    }

    static Integer helper(BinaryTreeNode node) {
        if (node == null)
            return 0;

        return Math.max(helper(node.left), helper(node.right)) + 1;
    }
}

/*
 * Iterative(BFS) approach
 * if(root == null){
 * return 0;
 * }
 * 
 * int height = 0;
 * 
 * // BFS
 * 
 * Queue<BinaryTreeNode> q = new LinkedList<>();
 * q.add(root);
 * 
 * while(!q.isEmpty()){
 * 
 * // capture the size of the queue !!!
 * int size=q.size();
 * height++;
 * 
 * for(int i = 0 ; i < size ; i++){
 * BinaryTreeNode curr = q.poll();
 * if(curr.left!=null) q.add(curr.left);
 * if(curr.right!=null) q.add(curr.right);
 * }
 * }
 * return height;
 */
