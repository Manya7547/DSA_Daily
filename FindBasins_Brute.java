import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindBasins_Brute {

    static int findSink(ArrayList<ArrayList<Integer>> matrix, ArrayList<ArrayList<Integer>> basin_ids, int row,
            int col) {
        int min_row = row;
        int min_col = col;

        // left cell
        if (col > 0 && matrix.get(row).get(col - 1) < matrix.get(min_row).get(min_col)) {
            min_row = row;
            min_col = col - 1;
        }

        // right cell
        if (col < matrix.get(0).size() - 1 && matrix.get(row).get(col + 1) < matrix.get(min_row).get(min_col)) {
            min_row = row;
            min_col = col + 1;
        }

        // top cell
        if (row > 0 && matrix.get(row - 1).get(col) < matrix.get(min_row).get(min_col)) {
            min_row = row - 1;
            min_col = col;
        }

        // bottom cell
        if (row < matrix.size() - 1 && matrix.get(row + 1).get(col) < matrix.get(min_row).get(min_col)) {
            min_row = row + 1;
            min_col = col;
        }

        // we are at sink
        if (min_row == row && min_col == col) {
            return basin_ids.get(row).get(col);
        }

        return findSink(matrix, basin_ids, min_row, min_col);
    }

    static ArrayList<Integer> find_basins(ArrayList<ArrayList<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        // create a matrix for cell ids
        ArrayList<ArrayList<Integer>> basin_ids = new ArrayList<>();
        // add rows
        for (int j = 0; j < m; j++) {
            basin_ids.add(new ArrayList<>());
        }
        // populate the basin_ids starting from 0
        int id = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                basin_ids.get(i).add(id++);
            }
        }

        // hashmap - id, count of cell forming a basin
        HashMap<Integer, Integer> map = new HashMap<>();

        // iterating through all the cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sinkId = findSink(matrix, basin_ids, i, j);
                map.put(sinkId, map.getOrDefault(sinkId, 0) + 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int x : map.keySet()) {
            ans.add(map.get(x));
        }

        Collections.sort(ans);
        return ans;

    }

}
