import java.util.LinkedList;
import java.util.Queue;

public class Knights_Tour {

    static int[] x_dir = { 2, 2, -2, -2, 1, 1, -1, -1 };
    static int[] y_dir = { -1, 1, -1, 1, -2, 2, -2, 2 };

    static Integer find_minimum_number_of_moves(Integer rows, Integer cols, Integer start_row, Integer start_col,
            Integer end_row, Integer end_col) {
        // bfs
        int[][] distance = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start_row, start_col });
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = -1;
            }
        }
        distance[start_row][start_col] = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curr_row = node[0];
            int curr_col = node[1];
            for (int i = 0; i < 8; i++) {
                int new_row = curr_row + x_dir[i];
                int new_col = curr_col + y_dir[i];
                if (new_row < 0 || new_col < 0 || new_row >= rows || new_col >= cols) {
                    continue;
                } else {
                    if (distance[new_row][new_col] == -1) {
                        distance[new_row][new_col] = distance[curr_row][curr_col] + 1;
                        q.add(new int[] { new_row, new_col });
                    }
                }
            }
        }
        return distance[end_row][end_col];
    }

}
