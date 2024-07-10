class Solution {
    public int countComponents(int n, int[][] edges) {
        // using DFS 

        // build a graph - adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i<edges.length ; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        int[] visited = new int[n];
        for(int i = 0 ; i<n ; i++){
            visited[i] = 0;
        }

        int c = 0; 
        for(int i = 0 ; i<n ; i++){
            if(visited[i]==0){
                c++;
                dfs(graph, visited, i);
            }
        }
        return c;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int s){
        visited[s] = 1;
        for(int neighbour: graph.get(s)){
            if(visited[neighbour]==0){
                dfs(graph, visited, neighbour);
            }
        }
    }
}