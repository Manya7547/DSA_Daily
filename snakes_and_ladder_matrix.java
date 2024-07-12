import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class snakes_and_ladder_matrix {

    static Integer minimum_number_of_rolls(Integer n, ArrayList<Integer> moves) {
        // initialize a graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i + dice < n) {
                    if (moves.get(i + dice) != -1) {
                        graph.get(i).add(moves.get(i + dice));
                    } else {
                        graph.get(i).add(i + dice);
                    }
                }
            }
        }

        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = -1;
        }

        bfs(graph, distance, 0);
        return distance[n - 1];
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, int[] distance, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        distance[s] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : graph.get(node)) {
                if (distance[neighbour] == -1) {
                    q.add(neighbour);
                    distance[neighbour] = distance[node] + 1;
                }
            }
        }
    }

}
