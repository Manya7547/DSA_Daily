import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakCount {

    static Integer word_break_count(ArrayList<String> dictionary, String txt) {

        int mod = 1000000007;

        // dp[i] represents the number of ways to break down substring (0,i) into
        // dictionary words

        // storing dict into hashset for easy lookup
        Set<String> dict = new HashSet<>(dictionary);

        int[] dp = new int[txt.length() + 1];

        dp[0] = 1; // base case

        for (int i = 1; i < txt.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dict.contains(txt.substring(j, i))) {
                    dp[i] += dp[j];
                    dp[i] %= mod;
                }
            }
        }

        return dp[txt.length()];
    }

}
