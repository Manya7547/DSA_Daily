import java.util.ArrayList;
import java.util.Collections;

public class findBasinsOptimal {
    static int findSink(ArrayList<ArrayList<Integer>> matrix, int[][] basins, int row, int col, int basin_index) {
        int min_row = row;
        int min_col = col;

        // Check each neighbor to find the minimum cell
        if (col > 0 && matrix.get(row).get(col - 1) < matrix.get(min_row).get(min_col)) {
            min_row = row;
            min_col = col - 1;
        }
        if (col < matrix.get(0).size() - 1 && matrix.get(row).get(col + 1) < matrix.get(min_row).get(min_col)) {
            min_row = row;
            min_col = col + 1;
        }
        if (row > 0 && matrix.get(row - 1).get(col) < matrix.get(min_row).get(min_col)) {
            min_row = row - 1;
            min_col = col;
        }
        if (row < matrix.size() - 1 && matrix.get(row + 1).get(col) < matrix.get(min_row).get(min_col)) {
            min_row = row + 1;
            min_col = col;
        }

        // Check if we've reached the sink
        if (min_row == row && min_col == col) {
            // If this cell is already labeled, return its basin index
            if (basins[row][col] != -1) {
                return basins[row][col];
            }
            basins[row][col] = basin_index; // Assign basin index to sink
        } else {
            // Propagate the sink's basin index backward
            basins[row][col] = findSink(matrix, basins, min_row, min_col, basin_index);
        }

        return basins[row][col];
    }

    static ArrayList<Integer> find_basins(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] basins = new int[m][n]; // Create matrix to label basin ids
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                basins[i][j] = -1; // Initialize to -1
            }
        }

        int basin_index = 0; // Start labeling basins from 0

        // Iterate through each cell to find or assign a basin
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findSink(matrix, basins, i, j, basin_index) == basin_index) {
                    basin_index++;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(basin_index, 0));

        // Count occurrences of each basin index in `basins`
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans.set(basins[i][j], ans.get(basins[i][j]) + 1);
            }
        }

        Collections.sort(ans); // Sort basin sizes
        return ans;
    }
}
