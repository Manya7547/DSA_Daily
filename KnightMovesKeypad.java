public class KnightMovesKeypad {
    static Long count_phone_numbers_of_given_length(Integer start_digit, Integer phone_number_length) {
        /*
         * Knight's valid moves on the phone keypad:
         * 1 - 6, 8
         * 2 - 7, 9
         * 3 - 4, 8
         * 4 - 3, 9, 0
         * 5 - nowhere
         * 6 - 7, 1, 0
         * 7 - 2, 6
         * 8 - 1, 3
         * 9 - 2, 4
         * 0 - 4, 6
         */

        int[][] jumps = {
                { 4, 6 }, // 0
                { 6, 8 }, // 1
                { 7, 9 }, // 2
                { 4, 8 }, // 3
                { 3, 9, 0 }, // 4
                {}, // 5 (no moves)
                { 1, 7, 0 }, // 6
                { 2, 6 }, // 7
                { 1, 3 }, // 8
                { 2, 4 } // 9
        };

        if (phone_number_length == 1) {
            return 1L; // Base case: Any digit itself is a valid phone number of length 1
        }

        // DP array: dp[length][digit] -> number of phone numbers of given length that
        // end at 'digit'
        long[][] dp = new long[phone_number_length + 1][10];

        // Initialize base case: length = 1
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        // Fill the DP table for lengths 2 to phone_number_length
        for (int length = 2; length <= phone_number_length; length++) {
            for (int digit = 0; digit <= 9; digit++) {
                dp[length][digit] = 0;
                // For each digit, check all possible jumps to this digit from previous digits
                for (int jump : jumps[digit]) {
                    dp[length][digit] += dp[length - 1][jump];
                }
            }
        }

        // Return the result for phone numbers of given length starting with
        // 'start_digit'
        return dp[phone_number_length][start_digit];
    }

}
