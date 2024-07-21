import java.util.ArrayList;

public class NChooseK {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> find_combinations(Integer n, Integer k) {
        // empty slate
        ArrayList<Integer> slate = new ArrayList<>();
        helper(n, 1, slate, k);
        return ans;
    }

    static void helper(int n, int curr, ArrayList<Integer> slate, int k) {
        // base case
        if (slate.size() >= k) {
            ans.add(new ArrayList<>(slate));
            return;
        }

        if (curr == n + 1) {
            return;
        }

        // recursive case
        slate.add(curr);
        helper(n, curr + 1, slate, k);
        slate.remove(slate.size() - 1);
        helper(n, curr + 1, slate, k);
    }

}
