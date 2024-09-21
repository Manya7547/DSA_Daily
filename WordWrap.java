import java.util.ArrayList;

public class WordWrap {

    /*
     * Intuition: Minimize the cost of line - optimization problem
     * 1) can't use greedy. Placing max words in the first line and so on does not
     * minimize the cost
     * 2) recursion would have repeating subproblems
     * 3) dp will be used
     * 
     * Algo:
     * 1) declare a dp[i] array to store the minimum cost of placing words i to n-1
     * 2) iterate backwards
     * 3) take words j to n-1 and add them to line i and check if they cross limit
     * or not
     * 4) if they cross limit - calc current cost and compare current cost + dp[j+1]
     * with dp[i] (already existing)
     */

    static Long solve_balanced_line_breaks(ArrayList<String> words, Integer limit) {
        int n = words.size();
        long[] dp = new long[n + 1];
        long infinite = Long.MAX_VALUE;
        long num_char = 0;
        long num_nonspace_char = 0;
        long num_words = 0;
        long current_cost = 0;

        for (int i = n - 1; i >= 0; i--) {
            num_nonspace_char = 0;
            num_words = 0;
            dp[i] = infinite;

            // collect the words in a line (from back) from i to n-1
            for (int j = i; j < n; j++) {
                num_words += 1;
                num_nonspace_char += words.get(j).length();
                num_char = num_nonspace_char + num_words - 1;

                // break before determining new dp[i] and current cost
                if (num_char > limit) {
                    break;
                }

                // if last word then don't include space
                current_cost = (j == n - 1) ? 0 : limit - num_char;
                current_cost = current_cost * current_cost * current_cost;

                // This represents the cost of placing the first line of words between index i
                // and j (i.e., the line containing the words [i, i+1, ..., j]).
                // dp[j + 1] represents the optimal (minimum) cost of breaking the sequence of
                // words starting from the (j+1)-th word onward.
                dp[i] = Math.min(dp[i], current_cost + dp[j + 1]);
            }
        }
        return dp[0];
    }

}
