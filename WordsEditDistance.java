public class WordsEditDistance {

    static Integer levenshtein_distance(String word1, String word2) {

        // dynamic programing table
        // dp[i][j] = minimum steps takes to convert word1 till i to word2 till jth
        // index
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 0;

        // populating row 0 and col 0.
        // row number of delete operations
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = i;
        }
        // col number of insert oprtations
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = i;
        }

        // recurrence relation

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // if the characters at i-1 and j-1 indices are same then no operation is
                // required
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }

        return dp[n][m];

    }

}
