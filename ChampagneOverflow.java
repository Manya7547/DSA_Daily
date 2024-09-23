public class ChampagneOverflow {

    static Double get_champagne_in_glass(Integer cups_poured, Integer query_row, Integer query_glass) {
        double[][] dp = new double[query_row + 1][query_row + 1];

        dp[0][0] = (double) cups_poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {

                if (dp[i][j] > 1) {
                    double overflow = dp[i][j] - 1;
                    dp[i][j] = 1;

                    dp[i + 1][j] += 0.5 * overflow;
                    dp[i + 1][j + 1] += 0.5 * overflow;
                }

            }
        }

        // if at the bottom alot of cups are left they should fall on the floor so then
        // return 1
        return Math.min(1, dp[query_row][query_glass]);
    }

}
