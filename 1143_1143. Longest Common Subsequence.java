class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        // each cell in dp will show the longest common subsequence between ith and jth
        // positions
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        // border values
        for (int row = 0; row < m + 1; row++) {
            dp[row][0] = 0;
        }
        for (int col = 0; col < n + 1; col++) {
            dp[0][col] = 0;
        }

        // iterative
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[m][n];
    }

}