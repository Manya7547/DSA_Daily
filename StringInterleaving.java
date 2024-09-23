public class StringInterleaving {

    static Boolean do_strings_interleave(String a, String b, String i) {
        int m = a.length();
        int n = b.length();
        int o = i.length();

        // if size of a and b is not equal to i
        if (m + n != o) {
            return false;
        }

        boolean dp[][] = new boolean[m + 1][n + 1];
        for (int k = 0; k < m + 1; k++) {
            for (int l = 0; l < n + 1; l++) {
                dp[k][l] = false;
            }
        }

        dp[m][n] = true;

        for (int a1 = m; a1 >= 0; a1--) {
            for (int b1 = n; b1 >= 0; b1--) {
                if (a1 < m && a.charAt(a1) == i.charAt(a1 + b1) && dp[a1 + 1][b1]) {
                    dp[a1][b1] = true;
                }
                if (b1 < n && b.charAt(b1) == i.charAt(a1 + b1) && dp[a1][b1 + 1]) {
                    dp[a1][b1] = true;
                }
            }
        }
        return dp[0][0];
    }

}
