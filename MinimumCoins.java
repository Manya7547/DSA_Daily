import java.util.ArrayList;

public class MinimumCoins {

    static Integer minimum_coins(ArrayList<Integer> coins, Integer value) {

        // dp[i] is the minim count of coins that sum up to i
        int[] dp = new int[value + 1];

        // populate the dp with default values - value+1
        for (int i = 0; i < value + 1; i++) {
            dp[i] = value + 1;
        }

        // minimum count of coins that sum up to 0 is 0
        dp[0] = 0;

        // minimum count of coins that sum up to i
        for (int i = 0; i < value + 1; i++) {
            for (int j = 0; j < coins.size(); j++) {
                // curr amount - coin
                if (i - coins.get(j) >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins.get(j)]);
                }
            }
        }

        return dp[value];
    }

}
