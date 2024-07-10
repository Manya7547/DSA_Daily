static int[] x_dir = { 0, 0, 0, 1, 1, 1, -1, -1, -1 };
static int[] y_dir = { 1, 0, -1, 1, 0, -1, 1, 0, -1 };

static Integer count_islands(ArrayList<ArrayList<Integer>> matrix) {
    int count = 0;
    for (int i = 0; i < matrix.size(); i++) {
        for (int j = 0; j < matrix.get(0).size(); j++) {
            if (matrix.get(i).get(j) == 1) {
                count++;
                helper(matrix, matrix.get(i).get(j), i, j);
            }
        }
    }
    return count;
}

static void helper(ArrayList<ArrayList<Integer>> matrix, int s, int i, int j) {
    // bfs search - store the position of source in a queue
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { i, j });
    matrix.get(i).set(j, 0);

    while (!q.isEmpty()) {
        int[] head = q.poll();
        int curr_row = head[0];
        int curr_col = head[1];

        // look in 8 directions
        for (int k = 0; k < 8; k++) {
            int new_row = curr_row + x_dir[k];
            int new_col = curr_col + y_dir[k];
            // if out of bound
            if (new_row < 0 || new_row >= matrix.size() || new_col < 0 || new_col >= matrix.get(0).size())
                continue;

            if (matrix.get(new_row).get(new_col) == 1) {
                q.add(new int[] { new_row, new_col });
                // visited 1's will become 0
                matrix.get(new_row).set(new_col, 0);
            }
        }
    }
}
