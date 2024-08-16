// Generate All Possible Expressions That Evaluate To The Given Target Value

import java.util.ArrayList;

public class Expressions_target {

    static ArrayList<String> generate_all_expressions(String s, Long target) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();
        helper(result, n, s, target, "", 0, 0L, 0L);
        return result;
    }

    static void helper(ArrayList<String> result, int n, String s, Long target, String slate, int pos, long curr_eval,
            long last_prod) {

        // base case
        if (pos == n) {
            if (curr_eval == target) {
                result.add(slate);
            }
            return;
        }

        // evaluating substring [pos, i] inclusive
        for (int i = pos; i < n; i++) {
            String str = s.substring(pos, i + 1);
            Long number = strToNumber(str);

            if (pos == 0) {
                helper(result, n, s, target, str, i + 1, number, number);
            } else {
                helper(result, n, s, target, slate + "+" + str, i + 1, curr_eval + number, number);
                helper(result, n, s, target, slate + "*" + str, i + 1, curr_eval - last_prod + (last_prod * number),
                        last_prod * number);
            }
        }
    }

    static long strToNumber(String str) {
        Long num = 0L;
        for (int i = 0; i < str.length(); i++) {
            num = num * 10L + (str.charAt(i) - '0');
        }
        return num;
    }

}
