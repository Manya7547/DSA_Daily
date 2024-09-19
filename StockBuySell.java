import java.util.ArrayList;

public class StockBuySell {
    /*
     * Intuition:
     * maintain max_difference and min_element variables and adjust them while
     * processing each element in the arr
     */

    static Integer find_maximum_profit(ArrayList<Integer> arr) {
        int max_diff = arr.get(1) - arr.get(0);
        int min_ele = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min_ele) {
                min_ele = arr.get(i);
            }

            if (max_diff < arr.get(i) - min_ele) {
                max_diff = arr.get(i) - min_ele;
            }
        }

        return max_diff <= 0 ? -1 : max_diff;
    }

}
