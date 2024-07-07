class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] table = new int[n + 1][amount + 1];

        table[0][0] = 1; // there is one way for 0 coins to amount to 0
        for (int row = 1; row < n + 1; row++) {
            table[row][0] = 1; // there is 1 way for coins to amount to 0 by not using them at all
        }
        for (int col = 1; col < amount + 1; col++) {
            table[0][col] = 0; // if there are no coins
        }

        for (int row = 1; row < n + 1; row++) {
            for (int col = 1; col < amount + 1; col++) {
                table[row][col] = table[row - 1][col]; // not including the current coin
                if (col - coins[row - 1] >= 0) {
                    table[row][col] += table[row][col - coins[row - 1]];
                }
            }
        }
        return table[n][amount];
    }
}
