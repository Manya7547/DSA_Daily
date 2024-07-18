import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Hashmap - integer with its frequency
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            frequency.put(arr.get(i), frequency.getOrDefault(arr.get(i), 0) + 1);
        }

        // Initialize a 2D ArrayList numbers where index is frequency. Max freq can be
        // equal to size
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i <= arr.size(); i++) {
            numbers.add(new ArrayList<>());
        }

        // Fill the numbers list based on frequencies
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            numbers.get(freq).add(num);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Iterate through numbers in descending order of frequency
        for (int i = numbers.size() - 1; i >= 0 && k > 0; i--) {
            if (!numbers.get(i).isEmpty()) {
                for (int num : numbers.get(i)) {
                    if (k == 0) {
                        break;
                    }
                    ans.add(num);
                    k--;
                }
            }
        }

        return ans;
    }

}
