import java.util.ArrayList;

public class CoinPlay {

    static int[][] dp;

    static Integer max_win(ArrayList<Integer> v) {
        dp = new int[v.size()][v.size()];
        return helper(0, v.size() - 1, v);
    }

    static int helper(int l, int r, ArrayList<Integer> v) {
        if (r < l) {
            return 0;
        }

        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        int left = v.get(l);
        int right = v.get(r);

        // Player 1 chooses either left or right
        dp[l][r] = Math.max(left + Math.min(helper(l + 2, r, v), helper(l + 1, r - 1, v)), right
                + Math.min(helper(l, r - 2, v), helper(l + 1, r - 1, v)));

        return dp[l][r];
    }

}
