class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // each cell in table represents the number of min edits needed
        int[][] table = new int[m + 1][n + 1];
        // base cases:
        table[0][0] = 0; // nothing to nothing
        // nothing to word2 (insertions)
        for (int col = 1; col < n + 1; col++) {
            table[0][col] = col;
        }

        // word1 to nothing (deletions)
        for (int row = 1; row < m + 1; row++) {
            table[row][0] = row;
        }
        int value = 0;
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                if (word1.charAt(row - 1) == word2.charAt(col - 1))
                    value = 0;
                else
                    value = 1;
                table[row][col] = Math.min(Math.min(table[row][col - 1] + 1, table[row - 1][col] + 1),
                        table[row - 1][col - 1] + value);
            }
        }
        return table[m][n];
    }
}