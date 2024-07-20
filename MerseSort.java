import java.util.ArrayList;

public class MerseSort {

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        helper(arr, 0, arr.size() - 1);
        return arr;
    }

    static void helper(ArrayList<Integer> arr, int start, int end) {
        // base case
        if (end <= start)
            return;

        // recursive case
        int mid = start + (end - start) / 2;
        helper(arr, start, mid);
        helper(arr, mid + 1, end);

        // merge phase
        int i = start;
        int j = mid + 1;

        // make a new list to store the sorted sub array
        ArrayList<Integer> list = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (arr.get(i) < arr.get(j)) {
                list.add(arr.get(i));
                i++;
            } else {
                list.add(arr.get(j));
                j++;
            }
        }

        while (i <= mid) {
            list.add(arr.get(i));
            i++;
        }
        while (j <= end) {
            list.add(arr.get(j));
            j++;
        }

        // transfer the sorted numbers into their indices
        j = 0;
        for (int m = start; m <= end; m++) {
            arr.set(m, list.get(j));
            j++;
        }
    }
}
