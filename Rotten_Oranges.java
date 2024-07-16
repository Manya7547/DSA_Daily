import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {

    static int[] x_dir = { 0, -1, 0, 1 };
    static int[] y_dir = { -1, 0, 1, 0 };
    static int min = 0;

    static Integer rotting_oranges(ArrayList<ArrayList<Integer>> grid) {
        Queue<int[]> q = new LinkedList<>();

        int m = grid.size();
        int n = grid.get(0).size();

        // add all rotten oranges into a queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        int minutes = 0; // number of while iterations

        while (!q.isEmpty()) {
            minutes++; // here in the end when no [rotten are left and q.size is 0 then it will
                       // increment one time extra
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] head = q.poll();
                int curr_row = head[0];
                int curr_col = head[1];
                for (int j = 0; j < 4; j++) {
                    int new_row = curr_row + x_dir[j];
                    int new_col = curr_col + y_dir[j];
                    if (new_row < 0 || new_col < 0 || new_row >= grid.size() || new_col >= grid.get(0).size()) {
                        continue;
                    }
                    if (grid.get(new_row).get(new_col) == 1) {
                        q.add(new int[] { new_row, new_col });
                        grid.get(new_row).set(new_col, 2);
                    }
                }

            }
        }

        // check if any fresh tomatoes left - if yes then return -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    return -1;
                }
            }
        }
        return Math.max(0, minutes - 1);
    }
}
