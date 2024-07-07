class Solution {
    public int minCost(int[][] costs) {
        int m = costs.length;
        int n = 3;
        int[][] table = new int[m][n];

        for (int i = 0; i < n; i++) {
            table[0][i] = costs[0][i];
        }

        for (int i = 1; i < m; i++) {
            table[i][0] = costs[i][0] + Math.min(table[i - 1][1], table[i - 1][2]);

            table[i][1] = costs[i][1] + Math.min(table[i - 1][2], table[i - 1][0]);

            table[i][2] = costs[i][2] + Math.min(table[i - 1][1], table[i - 1][0]);
        }

        return Math.min(table[m - 1][0], Math.min(table[m - 1][1], table[m - 1][2]));
    }
}