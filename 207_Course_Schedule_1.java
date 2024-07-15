import java.util.ArrayList;

class Course_Schedule {
    private int timestamp = 0;
    private ArrayList<Integer> ans = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }

        int[] visited = new int[numCourses];
        int[] arrival = new int[numCourses];
        int[] departure = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            visited[i] = -1;
            arrival[i] = -1;
            departure[i] = -1;
        }

        // try all possible nodes
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == -1) {
                if (cycle_dfs(i, graph, visited, arrival, departure))
                    return false;
            }
        }

        return true;
    }

    public boolean cycle_dfs(int s, ArrayList<ArrayList<Integer>> graph, int[] visited, int[] arrival,
            int[] departure) {
        arrival[s] = timestamp++;
        visited[s] = 1;

        for (int neighbour : graph.get(s)) {
            if (visited[neighbour] == -1) {
                if (cycle_dfs(neighbour, graph, visited, arrival, departure)) { // cycle found
                    return true;
                }
            } else {
                if (departure[neighbour] == -1) { // not yet departed but visited again so its a cycle/ back edge
                    return true;
                }

            }
        }

        departure[s] = timestamp++;
        return false;
    }
}
