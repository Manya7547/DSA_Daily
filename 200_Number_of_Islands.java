class Solution {
    public int numIslands(char[][] grid) {
        int[] x_dir = { 0, 0, 1, -1 };
        int[] y_dir = { -1, 1, 0, 0 };
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, x_dir, y_dir);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j, int[] x_dir, int[] y_dir) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        grid[i][j] = '0';
        while (!q.isEmpty()) {
            int[] head = q.poll();
            int curr_row = head[0];
            int curr_col = head[1];
            for (int k = 0; k < 4; k++) {
                int new_row = curr_row + x_dir[k];
                int new_col = curr_col + y_dir[k];
                if (new_row < 0 || new_col < 0 || new_row >= grid.length || new_col >= grid[0].length)
                    continue;
                if (grid[new_row][new_col] == '1') {
                    q.add(new int[] { new_row, new_col });
                    grid[new_row][new_col] = '0';
                }
            }
        }
    }
}