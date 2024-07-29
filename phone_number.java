import java.util.ArrayList;

public class phone_number {

    static ArrayList<String> ans = new ArrayList<>();

    static ArrayList<String> get_words_from_phone_number(String phone_number) {
        StringBuilder sb = new StringBuilder();
        // arrayList of string
        String[] arr = new String[10];
        arr[0] = "";
        arr[1] = "";
        arr[2] = "abc";
        arr[3] = "def";
        arr[4] = "ghi";
        arr[5] = "jkl";
        arr[6] = "mno";
        arr[7] = "pqrs";
        arr[8] = "tuv";
        arr[9] = "wxyz";
        helper(0, arr, sb, phone_number);

        if (ans.size() == 0) {
            ans.add("");
        }
        return ans;
    }

    static void helper(int curr, String[] arr, StringBuilder sb, String phone_number) {
        // base case
        if (curr >= phone_number.length()) {
            String str = sb.toString();
            ans.add(str);
            return;
        }

        // recursive case
        int ph = phone_number.charAt(curr) - '0';
        if (ph == 0 || ph == 1) { // skip
            helper(curr + 1, arr, sb, phone_number);
        } else {
            String letters = arr[ph];
            for (int i = 0; i < letters.length(); i++) {
                // Add the character
                sb.append(letters.charAt(i));
                helper(curr + 1, arr, sb, phone_number);
                // Remove the character (backtrack)
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /*
     * 1 - ""
     * 2 - "abc"
     * 3 - "def"
     * 4 - "ghi"
     * 5 - "jkl"
     * 6 - "mno"
     * 7 - "pqrs"
     * 8 - "tuv"
     * 9 - "wxyz"
     * 0 - ""
     */
}
