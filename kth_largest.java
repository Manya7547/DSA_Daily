import java.util.ArrayList;
import java.util.PriorityQueue;

public class kth_largest {

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream,
            ArrayList<Integer> append_stream) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < initial_stream.size(); i++) {
            pq.add(initial_stream.get(i));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < append_stream.size(); i++) {
            pq.add(append_stream.get(i)); // first push the append element
            if (pq.size() > k)
                pq.poll();
            ans.add(pq.peek());
        }
        return ans;
    }

}
