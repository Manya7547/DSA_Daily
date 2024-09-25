import java.util.ArrayList;

public class RobberyHousesDP {
    /*
     * 1) recursive/iterative - explore every combination - exhaustive search -
     * update the max sum
     * 2) dp - pure dp structure, bottom up tabulation method
     * dp[i] represents the sum of values robbed from houses till i'th index
     * - we can either skip the ith house and include the sum till the adjacent
     * index
     * - or we can include the current house(i) and add it to the sum one place
     * before dp[i-2]
     * - we only have to maintain 2 values essentially
     */

    static Integer maximum_stolen_value(ArrayList<Integer> values) {
        int rob1 = 0;
        int rob2 = 0;

        for (int i = 0; i < values.size(); i++) {
            int temp = Math.max(values.get(i) + rob1, rob2);

            // rob1 and rob2 shift one place ahead
            rob1 = rob2;
            rob2 = temp;
        }

        // rob2 is the final answer at the end
        return rob2;
    }

}
