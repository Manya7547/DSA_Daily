import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class flood_fill {

    static int[] x_dir = { 0, 0, -1, 1 };
    static int[] y_dir = { 1, -1, 0, 0 };

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color,
            ArrayList<ArrayList<Integer>> image) {
        // add given node to a queue
        // search it's adjacent nodes - in bounds
        // add the neighbours of same value into the queue

        Queue<int[]> q = new LinkedList<>();
        int old = image.get(pixel_row).get(pixel_column);

        if (new_color == old)
            return image;

        image.get(pixel_row).set(pixel_column, new_color);
        q.add(new int[] { pixel_row, pixel_column });
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curr_row = node[0];
            int curr_col = node[1];
            for (int i = 0; i < 4; i++) {
                int new_row = curr_row + x_dir[i];
                int new_col = curr_col + y_dir[i];
                if (new_row >= 0 && new_col >= 0 && new_row < image.size() && new_col < image.get(0).size()
                        && image.get(new_row).get(new_col) == old) {
                    q.add(new int[] { new_row, new_col });
                    image.get(new_row).set(new_col, new_color);
                }
            }
        }
        return image;
    }

}
