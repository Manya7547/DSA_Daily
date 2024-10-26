import java.util.HashMap;

public class transposeGraph {

    static HashMap<Integer, GraphNode> visited = new HashMap<>();

    static GraphNode create_transpose(GraphNode node) {
        dfs(node);
        // return any of the node from the reversed graph
        return visited.get(1);
    }

    static void dfs(GraphNode node) {

        // create a node and add it to the visited hashmap
        GraphNode curr = new GraphNode(node.value);
        visited.put(curr.value, curr);

        // iterate through it's neighbors
        int n = node.neighbors.size();
        for (int i = 0; i < n; i++) {
            // if a neighbor of curr node is unvisited then visit it (DFS)
            if (visited.containsKey(node.neighbors.get(i).value) == false) {
                dfs(node.neighbors.get(i));
            }
            // if it is visited - add curr node as neighbors of neighbors
            // select the neighbor in map - add to it's neighbors array
            visited.get(node.neighbors.get(i).value).neighbors.add(visited.get(node.value));

        }
    }

}
