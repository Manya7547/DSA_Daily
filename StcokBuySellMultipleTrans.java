import java.util.ArrayList;

public class StcokBuySellMultipleTrans {

    /*
     * Intuition: Greedy - Keep accumulating the profit as long the price next day
     * grater than the price at current day
     */

    static Integer get_maximum_profit(ArrayList<Integer> prices) {
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > prices.get(i - 1)) {
                profit += (prices.get(i) - prices.get(i - 1));
            }
        }
        return profit;
    }

}
