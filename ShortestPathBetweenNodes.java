public class ShortestPathBetweenNodes {

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

    static boolean findPath(BinaryTreeNode root, Integer value, StringBuilder path) {
        if (root == null) {
            return false; // reached dead end
        }

        if (root.value.equals(value)) {
            return true;
        }

        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // backtrack

        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1); // backtrack

        return false;
    }

    static String shortest_path(BinaryTreeNode root, Integer start_node_value, Integer end_node_value) {
        StringBuilder rootToStart = new StringBuilder();
        StringBuilder rootToEnd = new StringBuilder();

        // Find the paths from root to start and root to end
        findPath(root, start_node_value, rootToStart);
        findPath(root, end_node_value, rootToEnd);

        // Reverse the StringBuilders to compare from the back
        rootToStart.reverse();
        rootToEnd.reverse();

        // Removing the common path suffix
        while (rootToStart.length() > 0 && rootToEnd.length() > 0
                && rootToStart.charAt(rootToStart.length() - 1) == rootToEnd.charAt(rootToEnd.length() - 1)) {
            rootToStart.deleteCharAt(rootToStart.length() - 1);
            rootToEnd.deleteCharAt(rootToEnd.length() - 1);
        }

        // Reverse `rootToEnd` to get the correct order
        rootToEnd.reverse();

        // Build the final path
        StringBuilder ans = new StringBuilder();

        // 'U' for each remaining step in `rootToStart` (to go up)
        for (int i = 0; i < rootToStart.length(); i++) {
            ans.append('U');
        }

        // Append the path to `end_node_value`
        ans.append(rootToEnd);

        return ans.toString();
    }

}
