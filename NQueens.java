import java.util.ArrayList;

public class NQueens {

    static ArrayList<ArrayList<String>> board = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    static ArrayList<ArrayList<String>> find_all_arrangements(Integer n) {

        // will store the column numbers of ith queen
        ArrayList<Integer> cols = new ArrayList<>();

        helper(n, cols);

        for (int i = 0; i < result.size(); i++) {
            board.add(generate(result.get(i), n));
        }
        return board;
    }

    // to find out all possible combinations
    static void helper(int n, ArrayList<Integer> cols) {
        if (cols.size() >= n) {
            result.add(new ArrayList<>(cols));
            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            if (isValid(i, n, cols)) {
                cols.add(i);
                helper(n, cols);
                cols.remove(cols.size() - 1);
            }
        }

    }

    static boolean isValid(int colNo, int n, ArrayList<Integer> cols) {
        // check for same column and same diagonal

        for (int i = 0; i < cols.size(); i++) {
            if (colNo == cols.get(i)) {
                return false;
            }
            int rowdiff = Math.abs(cols.size() - i);
            int coldiff = Math.abs(colNo - cols.get(i));
            if (rowdiff == coldiff)
                return false;
        }
        return true;
    }

    // generate the board
    // 2, 0, 3, 1 - arr
    static ArrayList<String> generate(ArrayList<Integer> arr, int n) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == arr.get(i)) {
                    str.append("q");
                } else {
                    str.append("-");
                }
            }
            list.add(str.toString());
        }
        return list;
    }
}
