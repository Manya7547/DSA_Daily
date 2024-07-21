import java.util.ArrayList;

public class LetterCasePermutation {

    static ArrayList<String> ans = new ArrayList<>();

    static ArrayList<String> letter_case_permutations(String s) {
        // string is immutable so we pass string builder
        helper(new StringBuilder(s), 0);
        return ans;
    }

    static void helper(StringBuilder sb, int curr) {
        // base case
        if (curr >= sb.length()) {
            String str = sb.toString();
            ans.add(str);
            return;
        }

        // character at curr is not a character
        if (!Character.isLetter(sb.charAt(curr))) {
            helper(sb, curr + 1);
            return;
        }

        // recursive case

        // convert curr into lower case
        char ch = sb.charAt(curr);
        sb.setCharAt(curr, Character.toLowerCase(ch));

        // update curr
        helper(sb, curr + 1);

        // restore
        sb.setCharAt(curr, ch);

        // upper case
        sb.setCharAt(curr, Character.toUpperCase(ch));

        // update curr
        helper(sb, curr + 1);
        // restore
        sb.setCharAt(curr, ch);
    }

}
