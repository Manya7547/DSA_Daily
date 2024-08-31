import java.util.ArrayList;
import java.util.PriorityQueue;

public class KNearest {

    static class Point {
        int x;
        int y;
        double distance;

        Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static ArrayList<ArrayList<Integer>> nearest_neighbours(Integer p_x, Integer p_y, Integer k,
            ArrayList<ArrayList<Integer>> n_points) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        // calculate distance and add into the queue
        for (int i = 0; i < n_points.size(); i++) {
            int x = n_points.get(i).get(0);
            int y = n_points.get(i).get(1);
            int x_diff = p_x - x;
            int y_diff = p_y - y;
            double distance = (double) (x_diff * x_diff + y_diff * y_diff);
            pq.offer(new Point(x, y, distance));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int j = 0; j < k; j++) {
            Point curr = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr.x);
            temp.add(curr.y);
            ans.add(temp);
        }
        return ans;
    }
}
