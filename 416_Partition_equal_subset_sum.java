class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) { // If sum is odd, can't partition equally
            return false;
        }
        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        // Base case: when sum is 0, empty subset is always valid
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        // Base case: when nums is empty, no subset is valid except the empty one
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // If current number is greater than current sum, skip it
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Two possibilities: either include the current number or not
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];
    }

}
