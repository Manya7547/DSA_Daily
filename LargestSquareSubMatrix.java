import java.util.ArrayList;

public class LargestSquareSubMatrix {
    /*
     * Intuition: This is an optimization problem.
     * Brute Force: exhaustive search - polynomial complexity
     * Using Decrease and conquer - dynamic programming approach
     * Each cell in table will store the maximum length of the square in which that
     * cell is the bottom right cell
     * 
     * Algo:
     * 1) Define a table with same dimensions
     * 2) Fill in row 0 and col 0 - either 0 or 1 because max size of those sq is 1
     * 3) iterate through each cell with nested for loop
     * 4) if a mat cell is 1 -> table[row][col] = 1 + min of the three predecessors
     * 5) else table cell is 0
     * 6) make a global size var to track max length then return it
     */

    static Integer largest_sub_square_matrix(Integer n, Integer m, ArrayList<ArrayList<Integer>> mat) {
        int[][] table = new int[n][m];
        int maxSize = 0;

        // fill in row 0
        for (int i = 0; i < m; i++) {
            table[0][i] = mat.get(0).get(i);
            maxSize = Math.max(maxSize, table[0][i]);
        }

        // fill in col 0
        for (int i = 0; i < n; i++) {
            table[i][0] = mat.get(i).get(0);
            maxSize = Math.max(maxSize, table[i][0]);

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat.get(i).get(j) == 1) {
                    table[i][j] = 1 + Math.min(Math.min(table[i - 1][j - 1], table[i - 1][j]), table[i][j - 1]);
                    maxSize = Math.max(maxSize, table[i][j]);
                } else {
                    table[i][j] = 0;
                }
            }
        }

        return maxSize;
    }

}
