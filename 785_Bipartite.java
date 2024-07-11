class Solution {
    public boolean isBipartite(int[][] graph) {
        // every graph which is a tree would be bipartite
        // a graph with a cycle with even length will be bipartite
        int n = graph.length;
        int[] visited = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
            parent[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!isBipartite(graph, visited, parent, i))
                    return false;
            }
        }
        return true;
    }

    private Boolean isBipartite(int[][] graph, int[] visited, int[] parent, int s) {
        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        parent[s] = -1; // source
        int[] distance = new int[visited.length];
        distance[s] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : graph[node]) {
                if (visited[neighbour] == -1) {
                    q.add(neighbour);
                    visited[neighbour] = 1;
                    parent[neighbour] = node;
                    distance[neighbour] = distance[node] + 1;
                }
                if (neighbour != parent[node]) { // cross edge - visited
                    if (distance[neighbour] == distance[node]) // cycle length is odd
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}