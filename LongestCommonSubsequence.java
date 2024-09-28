public class LongestCommonSubsequence {

    static String lcs(String a, String b) {
        // while comparing, either i can keep a character or delete it
        // if i explore every possible combination - 4^n exponential
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        // dp[i][j] denotes the common subsequence in s1(0, 1) and s2(0, j)

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // reconstruct the ans string

        StringBuilder str = new StringBuilder();
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            // if characters are same, move diagonally up
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                str.insert(0, a.charAt(i - 1));
                i--;
                j--;
            }
            // move to the direction with max value
            else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        if (str.length() == 0) {
            return "-1";
        }

        return str.toString();

    }

}
