import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindClosestGates {

    static ArrayList<ArrayList<Integer>> find_closest_gates(ArrayList<ArrayList<Integer>> grid) {

        // bfs traversal starting from all the gates

        // queue for bfs - storing i,j indices of the cell
        Queue<int[]> q = new LinkedList<>();
        int m = grid.size();
        int n = grid.get(0).size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if it's a gate then add it to the queue
                if (grid.get(i).get(j) == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int[] x = { 0, 0, 1, -1 };
        int[] y = { 1, -1, 0, 0 };
        while (!q.isEmpty()) {
            int[] u = q.poll();
            // checking for cells in all four directions
            for (int i = 0; i < 4; i++) {
                int X = u[0] + x[i];
                int Y = u[1] + y[i];
                if (X >= 0 && X < m && Y >= 0 && Y < n) {
                    // check if the neighbour's value is smaller
                    if (grid.get(u[0]).get(u[1]) + 1 < grid.get(X).get(Y)) {
                        // add one more to the distance
                        grid.get(X).set(Y, grid.get(u[0]).get(u[1]) + 1);
                        q.add(new int[] { X, Y });
                    }
                }
            }
        }

        return grid;

    }

}
