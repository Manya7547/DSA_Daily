//Given a list of numbers, the task is to insert these numbers into a stream and 
//find the median of the stream after each insertion. If the median is a non-integer, 
//consider it’s floor value.

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OnlineMedian {

    public static PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
    public static PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>((a, b) -> {
        return b - a;
    });

    public static void addNum(int num) {
        max_heap.add(num);
        min_heap.add(max_heap.peek());
        max_heap.poll();

        //
        if (min_heap.size() > max_heap.size()) {
            max_heap.add(min_heap.peek());
            min_heap.poll();
        }

    }

    public static int findCurrentMedian() {
        if (max_heap.size() == min_heap.size()) {
            return (max_heap.peek() + min_heap.peek()) / 2;
        }

        return max_heap.peek();
    }

    static ArrayList<Integer> online_median(ArrayList<Integer> stream) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < stream.size(); i++) {
            addNum(stream.get(i));
            result.add(findCurrentMedian());
        }

        return result;

    }
}
