import java.util.ArrayList;

public class TowerOfHanoi {

    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> tower_of_hanoi(Integer n) {
        helper(1, 3, 2, n);
        return result;

    }

    static void helper(int from_peg, int to_peg, int aux_peg, int n) {
        // base case
        if (n == 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(from_peg);
            temp.add(to_peg);
            result.add(temp);
            return;
        }

        // recursive case
        // transfer n-1 disks from from_peg to aux_peg
        helper(from_peg, aux_peg, to_peg, n - 1);

        // transfer the nth disk from from_peg to to_peg
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(from_peg);
        temp.add(to_peg);
        result.add(temp);

        // finally transfer n-1 disks from aux_peg to to_peg using from_peg as an
        // auxillary peg
        helper(aux_peg, to_peg, from_peg, n - 1);
    }

}
