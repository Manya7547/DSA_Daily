import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class subsetWithDuplicateCharacters {

    static ArrayList<String> ans = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    static ArrayList<String> get_distinct_subsets(String s) {
        // sort the string
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // n log n
        String sortedstr = new String(arr);
        StringBuilder sb = new StringBuilder();

        helper(sortedstr, 0, sb);
        return ans;
    }

    static void helper(String s, int curr, StringBuilder sb) {
        // base case
        if (curr >= s.length()) {
            String str = sb.toString();
            if (!set.contains(str)) {
                set.add(str);
                ans.add(str);
            }
            return;
        }

        // recursive case:

        // add a character
        sb.append(s.charAt(curr));
        helper(s, curr + 1, sb);

        // remove a character
        sb.deleteCharAt(sb.length() - 1);
        helper(s, curr + 1, sb);
    }

}
