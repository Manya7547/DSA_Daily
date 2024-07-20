import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FourSum {

    static ArrayList<ArrayList<Integer>> four_sum(ArrayList<Integer> arr, Integer target) {
        Collections.sort(arr);
        Set<String> unique = new HashSet<>(); // stores unique quadruples
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // two nested for loops give 1st and 2nd number
        for (int i = 0; i < arr.size() - 3; i++) { // 3 places for rest numbers
            for (int j = i + 1; j < arr.size() - 2; j++) { // 2 places left for other numbers, i and j do not overlap
                int start = j + 1;
                int end = arr.size() - 1;

                // two sum
                while (start < end) {
                    int sum = arr.get(i) + arr.get(j) + arr.get(start) + arr.get(end);
                    if (sum < target)
                        start++;
                    else if (sum > target)
                        end--;
                    else {
                        // making a string to add the current quadruple
                        StringBuilder sb = new StringBuilder();
                        sb.append(arr.get(i));
                        sb.append(arr.get(j));
                        sb.append(arr.get(start));
                        sb.append(arr.get(end));
                        String code = sb.toString(); // converting sb to string
                        if (!unique.contains(code)) { // checking if this already exists in set or not
                            unique.add(code);
                            ArrayList<Integer> res = new ArrayList<>();
                            res.add(arr.get(i));
                            res.add(arr.get(j));
                            res.add(arr.get(start));
                            res.add(arr.get(end));
                            ans.add(res);
                        }
                        start++;
                        end--;
                        while (start < end && arr.get(start).equals(arr.get(start - 1)))
                            start++;
                        while (start < end && arr.get(end).equals(arr.get(end + 1)))
                            end--;
                    }
                }
            }
        }
        return ans;
    }
}
