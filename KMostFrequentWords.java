import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KMostFrequentWords {

    static ArrayList<String> k_most_frequent(Integer k, ArrayList<String> words) {
        // the index of array list will tell the number of occurences
        int maxFreq = words.size();
        ArrayList<ArrayList<String>> arr = new ArrayList<>(maxFreq + 1);

        // map will store - word and it's frequency
        HashMap<String, Integer> map = new HashMap<>();

        // fill the hash map
        for (int i = 0; i < words.size(); i++) {
            map.put(words.get(i), map.getOrDefault(words.get(i), 0) + 1);
        }

        // initialize the arrayList
        for (int i = 0; i <= words.size(); i++) {
            arr.add(new ArrayList<>());
        }

        // fill the array list of array list of string (multiple strings can have same
        // frequency)
        for (String str : map.keySet()) {
            arr.get(map.get(str)).add(str);
        }

        // sort each arraylist so they appear in lexicographical order
        for (ArrayList<String> list : arr) {
            Collections.sort(list);
        }

        // max number of frequency can be equal to size of words
        ArrayList<String> ans = new ArrayList<>();
        int count = 0;
        for (int i = words.size(); i >= 0; i--) {
            if (arr.get(i).size() > 0) {
                int start = 0;
                while (start <= arr.get(i).size() - 1 && count < k) {
                    ans.add(arr.get(i).get(start));
                    start++;
                    count++;
                }
            }
        }
        return ans;
    }
}
