import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestinArray {

    static Integer kth_largest_in_an_array(ArrayList<Integer> numbers, Integer k) {
        // Quick sort - randomised pivot - worst case O(n*n) partitioning can be skewed
        // priority queue - min heap of size k - just like in stream question

        // min heap - will store the top k elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) { // O(k)
            pq.add(numbers.get(i));
        }

        for (int i = k; i < numbers.size(); i++) {
            // only add when number is larger than head
            if (numbers.get(i) > pq.peek()) {
                pq.add(numbers.get(i));
                pq.poll();
            }
        }

        return pq.peek();
    }
}
