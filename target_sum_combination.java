import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class target_sum_combination {

    static Set<ArrayList<Integer>> set = new HashSet<>();
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> generate_all_combinations(ArrayList<Integer> arr, Integer target) {
        ArrayList<Integer> slate = new ArrayList<>();
        helper(arr, 0, slate, 0, target);
        return ans;
    }

    static void helper(ArrayList<Integer> arr, int curr, ArrayList<Integer> slate, int sum, int target) {
        // base case
        if (sum == target) {
            ArrayList<Integer> sl = new ArrayList<>(slate);
            if (!set.contains(sl)) {
                ans.add(new ArrayList<>(sl));
                set.add(new ArrayList<>(sl));
            }
            return;
        }
        if (curr >= arr.size() || sum > target) {
            return;
        }

        // recursive case:

        sum += arr.get(curr);
        slate.add(arr.get(curr));
        helper(arr, curr + 1, slate, sum, target);
        slate.remove(slate.size() - 1);
        sum -= arr.get(curr);
        helper(arr, curr + 1, slate, sum, target);
    }

}
