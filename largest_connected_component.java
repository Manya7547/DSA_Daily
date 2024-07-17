import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class largest_connected_component {

    static int max = 0;
    static HashMap<Integer, Integer> map = new HashMap<>(); // id and size
    static int[] x_dir = { 0, 0, 1, -1 };
    static int[] y_dir = { 1, -1, 0, 0 };

    static Integer largest_connected_component(ArrayList<ArrayList<Integer>> grid) {
        // perform dfs and give each cluster a unique id starting from 2 (because 0 and
        // 1 are already there)
        // HashMap - will store id, size
        // start from a 0 cell and do dfs and check if it's neighbours belong to the
        // some cluster
        // calculate max and update max
        int m = grid.size();
        int n = grid.get(0).size();
        int id = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    int size = dfs(grid, i, j, id);
                    map.put(id, size);
                    id++;
                }
            }
        }
        for (int s : map.keySet()) {
            max = Math.max(map.get(s), max);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 0) {
                    Set<Integer> ids = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int new_row = i + x_dir[k];
                        int new_col = j + y_dir[k];
                        if (new_row < 0 || new_col < 0 || new_row >= grid.size() || new_col >= grid.get(0).size()) {
                            continue;
                        }
                        if (grid.get(new_row).get(new_col) != 0) {
                            ids.add(grid.get(new_row).get(new_col));
                        }
                    }
                    int sum = 1;
                    for (int x : ids) {
                        sum = sum + map.get(x);
                    }
                    max = Math.max(sum, max);
                }
            }

        }
        return max;
    }

    static int dfs(ArrayList<ArrayList<Integer>> grid, int i, int j, int id) {
        int size = 1;
        grid.get(i).set(j, id);
        for (int k = 0; k < 4; k++) {
            int new_row = i + x_dir[k];
            int new_col = j + y_dir[k];
            if (new_row < 0 || new_col < 0 || new_row >= grid.size() || new_col >= grid.get(0).size()) {
                continue;
            }
            if (grid.get(new_row).get(new_col) == 1) {
                size += dfs(grid, new_row, new_col, id);
            }
        }
        return size;
    }

}
