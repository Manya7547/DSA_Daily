import java.util.ArrayList;

public class merge_sorted_arrays {

    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        for (int x = 0; x < first.size(); x++) {
            second.set(x + first.size(), second.get(x));
            second.set(x, 0);
        }

        int i = 0;
        int j = first.size();
        int curr = 0;

        while (i < first.size() && j < second.size()) {
            if (first.get(i) < second.get(j)) {
                second.set(curr, first.get(i));
                curr++;
                i++;
            } else {
                second.set(curr, second.get(j));
                j++;
                curr++;
            }
        }

        // gathering phase
        while (i < first.size()) {
            second.set(curr, first.get(i));
            i++;
            curr++;
        }

        while (j < second.size()) {
            second.set(curr, second.get(j));
            j++;
            curr++;
        }

        return second;
    }

}
