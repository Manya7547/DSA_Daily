class Solution {
    public int numWays(int n, int k) {
        // two variables to be maintained
        // lastTwoSame and lastTwoDifferent
        if (n == 1) {
            return k;
        }

        int lastTwoSame = k;
        int lastTwoDiff = k * (k - 1);
        int total = lastTwoSame + lastTwoDiff;

        for (int i = 3; i <= n; i++) {
            lastTwoSame = lastTwoDiff; // last color repeated in lasttwodiff
            lastTwoDiff = total * (k - 1); // try appending a color which is different from last color - k-1 options
            total = lastTwoSame + lastTwoDiff;
        }
        return total;
    }
}