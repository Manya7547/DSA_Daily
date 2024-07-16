import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Zombie_Clusters {

    static Integer zombie_cluster(ArrayList<String> zombies) {
        int c = 0;
        int n = zombies.size();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = -1;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (zombies.get(i).charAt(j) == '1' && i != j) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < zombies.size(); i++) {
            if (visited[i] == -1) {
                c++;
                bfs(i, graph, visited);
            }
        }
        return c;
    }

    static void bfs(int s, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        visited[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : graph.get(node)) {
                if (visited[neighbour] == -1) {
                    visited[neighbour] = 1;
                    q.add(neighbour);
                }
            }
        }
    }

}
