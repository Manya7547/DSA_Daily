public class max_area_island {

    static int[] x_dir = { 0, 0, 1, -1 };
    static int[] y_dir = { 1, -1, 0, 0 };

    static Integer max_island_size(ArrayList<ArrayList<Integer>> grid) {
        int size = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    size = Math.max(size, bfs(grid, i, j));
                }
            }
        }
        return size;
    }

    static Integer bfs(ArrayList<ArrayList<Integer>> grid, int i, int j) {
        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        grid.get(i).set(j, 0);

        while (!q.isEmpty()) {
            int[] head = q.poll();
            size++;
            int curr_row = head[0];
            int curr_col = head[1];
            for (int k = 0; k < 4; k++) {
                int new_row = curr_row + x_dir[k];
                int new_col = curr_col + y_dir[k];
                if (new_row < 0 || new_col < 0 || new_row >= grid.size() || new_col >= grid.get(0).size()) {
                    continue;
                }
                if (grid.get(new_row).get(new_col) == 1) {
                    q.add(new int[] { new_row, new_col });
                    grid.get(new_row).set(new_col, 0);
                }
            }
        }
        return size;
    }

}
