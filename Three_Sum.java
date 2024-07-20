import java.util.ArrayList;
import java.util.Collections;

public class Three_Sum {

    static ArrayList<String> find_zero_sum(ArrayList<Integer> arr) {
        Collections.sort(arr);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            // if a number is duplicate we skip it so we don't get duplicate triplets
            if (i == 0 || !arr.get(i).equals(arr.get(i - 1)))
                twoSum(arr, i, ans);
        }
        return ans;
    }

    static void twoSum(ArrayList<Integer> arr, int i, ArrayList<String> ans) {
        int start = i + 1;
        int end = arr.size() - 1;
        int sum = 0 - arr.get(i);

        while (start < end) {
            if (arr.get(start) + arr.get(end) < sum)
                start++;
            else if (arr.get(start) + arr.get(end) > sum)
                end--;
            else {
                ans.add(arr.get(i) + "," + arr.get(start) + "," + arr.get(end));
                start++;
                end--;
                // we also don;t want duplicate start and end values
                while (start < end && arr.get(start).equals(arr.get(start - 1)))
                    start++;
                while (start < end && arr.get(end).equals(arr.get(end + 1)))
                    end--;
            }
        }
    }

}
