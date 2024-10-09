public class UniquePaths {

    static Integer unique_paths(Integer n, Integer m) {
        int dp[][] = new int[n][m];
        dp[0][0] = 0;

        if (m == 1 || n == 1) {
            return 1;
        }

        // only one way along the 0th column
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        // only one way along the 0th row
        for (int j = 1; j < m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n - 1][m - 1];
    }

}
