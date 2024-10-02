import java.util.ArrayList;

public class CutTheRod {

    static Integer get_maximum_profit(ArrayList<Integer> price) {
        // Write your code here.
        int n = price.size();
        int[] dp = new int[n + 1];

        // table[i] denotes the maximum profit of a rod of length i
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            int maxprofit = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) { // cutting the rode at position j
                maxprofit = Math.max(maxprofit, price.get(j) + dp[i - j - 1]); // price of each cut piece
            }
            dp[i] = maxprofit;
        }
        return dp[n];
    }

}
