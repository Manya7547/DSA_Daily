import java.util.ArrayList;

public class PascalsTriangle {

    static ArrayList<ArrayList<Integer>> find_pascal_triangle(Integer n) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            pascal.add(new ArrayList<>());
        }

        // populate the pascal 2d arraylist

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                pascal.get(i).add(1);
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < pascal.get(i).size() - 1; j++) {
                int sum = pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j);
                pascal.get(i).set(j, sum % mod);
            }
        }

        return pascal;
    }

}
