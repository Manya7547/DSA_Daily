import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermuteArrayOfIntWithDuplicates {

    static Set<ArrayList<Integer>> set = new HashSet<>();
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
        helper(arr, 0);
        return ans;
    }

    static void helper(ArrayList<Integer> arr, int fixed) {
        if (fixed > arr.size() - 1) {
            if (!set.contains(arr)) { // check if arraylist exists in the set
                ans.add(new ArrayList<>(arr));
                set.add(new ArrayList<>(arr));
            }

            return;
        }

        else {
            for (int i = fixed; i < arr.size(); i++) {
                swap(i, fixed, arr);
                helper(arr, fixed + 1);
                swap(i, fixed, arr);
            }
        }

    }

    static void swap(int i, int j, ArrayList<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
