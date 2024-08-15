import java.util.ArrayList;

public class Sudoku_Solver {

    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        helper(board, 0, 0);
        return board;
    }

    static boolean helper(ArrayList<ArrayList<Integer>> board, int row, int col) {
        // beyond the last row -> that means one successful configuration
        if (row == 9) {
            return true;
        }

        // last column -> go to the beginning of the next row
        if (col == 9) {
            return helper(board, row + 1, 0);
        }

        // skip if cell already has a number
        if (board.get(row).get(col) != 0) {
            return helper(board, row, col + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (rowValid(i, row, board) && colValid(i, col, board) && boxValid(i, row, col, board)) {
                board.get(row).set(col, i);

                if (helper(board, row, col + 1)) {
                    return true;
                }

                board.get(row).set(col, 0);

            }
        }
        return false;
    }

    static boolean rowValid(int num, int row, ArrayList<ArrayList<Integer>> board) {
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i) == num)
                return false;
        }
        return true;
    }

    static boolean colValid(int num, int col, ArrayList<ArrayList<Integer>> board) {
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col) == num) {
                return false;
            }
        }
        return true;
    }

    static boolean boxValid(int num, int row, int col, ArrayList<ArrayList<Integer>> board) {
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board.get(i).get(j) == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
