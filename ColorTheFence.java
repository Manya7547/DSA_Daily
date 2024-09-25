public class ColorTheFence {

    static Integer number_of_ways(Integer n, Integer k) {

        int mod = 1000000007;

        // the ans will be at dp[n]
        // dp[i] represents the number of ways i posts can be coloured using k colours
        long[] dp = new long[n + 1];

        // Base cases
        if (n == 0)
            return 0; // No posts to paint
        if (n == 1)
            return k; // Only 1 post, k choices

        // base cases
        dp[1] = k;
        dp[2] = (long) k + k * (k - 1);

        // populate the dp array
        // case 1: ith post and i-1th post are of same color - dp[i-i]
        // case 2: ith post and i-1th post are of different color - dp[i-1] * k-1
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1)) % mod;
        }

        return (int) dp[n];
    }

}
