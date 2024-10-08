import java.util.ArrayList;

public class RodCutting {

    /*
     * 4 inches rod
     * index+1 inch rod price is the value at that index
     * 
     * 1 - 1 - 1 - 1
     * 1 - 1 - 2
     * 1 - 2 - 1
     * 1 - 3
     * 2 - 2
     * 2 - 1 - 1
     * 2 - 2
     * 3 - 1
     * 4
     */

    static Integer get_maximum_profit(ArrayList<Integer> price) {

        // dp[i] denotes the max total profit of a rod of inch i
        int[] dp = new int[price.size() + 1];
        dp[0] = 0;

        for (int i = 1; i < price.size() + 1; i++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxProfit = Math.max(maxProfit, price.get(j) + dp[i - j - 1]);
            }
            dp[i] = maxProfit;
        }
        return dp[price.size()];
    }

}
