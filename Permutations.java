import java.util.ArrayList;

public class Permutations {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        // Write your code here.
        helper(arr, 0);
        return ans;
    }

    static void helper(ArrayList<Integer> arr, int fixed) {
        // base case
        if (fixed >= arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        // recursive case - swap the fixed index with i recursively
        else {
            for (int i = fixed; i < arr.size(); i++) {
                swap(arr, i, fixed);
                helper(arr, fixed + 1);
                swap(arr, i, fixed);
            }
        }
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
