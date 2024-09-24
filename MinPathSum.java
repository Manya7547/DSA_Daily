import java.util.ArrayList;

public class MinPathSum {

    static Integer get_minimum_path_sum(ArrayList<ArrayList<Integer>> triangle) {

        // dynamic programming grid - triangle
        // dp[i,j] represents the minimum distance travelled to reach at dp[i,j]
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                dp.get(i).add(0);
            }
        }
        // minimum distance to reach 0,0
        dp.get(0).add(triangle.get(0).get(0));

        // populate the edges. Only one possible path along the edges
        for (int i = 1; i < triangle.size(); i++) {
            dp.get(i).set(0, triangle.get(i).get(0) + dp.get(i - 1).get(0));
            dp.get(i).set(i, triangle.get(i).get(i) + dp.get(i - 1).get(i - 1));
        }

        for (int i = 2; i < triangle.size(); i++) {
            for (int j = 1; j <= i - 1; j++) {
                int minvalue = Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j);
                dp.get(i).set(j, minvalue);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            min = Math.min(dp.get(dp.size() - 1).get(i), min);
        }

        return min;
    }
}
