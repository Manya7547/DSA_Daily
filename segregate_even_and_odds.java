import java.util.ArrayList;

public class segregate_even_and_odds {

    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Hoarse's partitioning technique

        int i = 0;
        int j = numbers.size() - 1;

        while (i < j) {
            int a = numbers.get(i);
            int b = numbers.get(j);
            if (a % 2 != 0 && b % 2 == 0) {
                swap(i, j, numbers);
                i++;
                j--;
            }
            if (b % 2 != 0) {
                j--;
            }
            if (a % 2 == 0) {
                i++;
            }
        }
        return numbers;
    }

    static void swap(int i, int j, ArrayList<Integer> numbers) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
