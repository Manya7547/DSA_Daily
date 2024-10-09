import java.util.ArrayList;

public class WordBreak {

    static Boolean word_break(String s, ArrayList<String> words_dictionary) {

        // dp[i] denotes if substring(0,i) can be broken down into dict words
        Boolean[] dp = new Boolean[s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i] = false;
        }
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i - j] == true && words_dictionary.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
