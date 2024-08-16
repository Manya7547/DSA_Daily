import java.util.ArrayList;

public class SquareSortedArray {

    static ArrayList<Integer> generate_sorted_array_of_squares(ArrayList<Integer> numbers) {
        // two pointer method

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            result.add(0);
        }
        int left = 0;
        int right = numbers.size() - 1;

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (Math.abs(numbers.get(left)) > Math.abs(numbers.get(right))) {
                result.set(i, numbers.get(left) * numbers.get(left));
                left++;
            } else {
                result.set(i, numbers.get(right) * numbers.get(right));
                right--;
            }
        }
        return result;
    }

}
