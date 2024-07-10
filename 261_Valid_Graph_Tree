class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ;i<n; i++){
            graph.add(new ArrayList<>());
        }

        // populate the graph
        for(int i = 0 ; i<edges.length ; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] visited = new int[n];
        for(int i = 0 ; i<n ; i++){
            visited[i] = -1;
        }

        int c = 0;
        int parent = -1; // for source

        for(int i = 0 ; i <n ; i++){
            if(visited[i]==-1){
                c++;
                if(!dfs(graph, visited, parent, i)){
                return false;
            }
            }
            if(c>1) 
                return false;
            
        }

        return true;
     }
     private boolean dfs(ArrayList<ArrayList<Integer>> graph,int[] visited, int parent, int s){
        visited[s] = 1;
        for(int neigh: graph.get(s)){
            if(visited[neigh]==-1){ 
                if(!dfs(graph, visited, s, neigh)){
                    return false;
                }
            }
            else{ // if it is visited 
                if(neigh != parent){
                    return false;
                }
            }
        }
        return true;
     }
}