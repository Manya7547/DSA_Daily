// There are n people living in a town. Some of them dislike each other. Given the value of n 
// and two equal length integer arrays called dislike1 and dislike2. For each i in [0, dislike1_size - 1],
// the person dislike1[i] dislikes the person dislike2[i]. Check if we can divide the people of the town 
// into two sets such that each person belongs to exactly one set and no two persons disliking each other 
// belong to the same set.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Friendly_Groups_IK {

    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < num_of_people; i++) {
            graph.add(new ArrayList<>());
        }

        // populate the graph
        for (int i = 0; i < dislike1.size(); i++) {
            int from = dislike1.get(i);
            int to = dislike2.get(i);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] visited = new int[num_of_people];

        // initialize visited with -1
        for (int i = 0; i < num_of_people; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < num_of_people; i++) {
            if (visited[i] == -1) {
                if (!helper(graph, visited, i, num_of_people)) {
                    return false;
                }
            }
        }
        return true;
    }

    static Boolean helper(ArrayList<ArrayList<Integer>> graph, int[] visited, int s, int n) {
        int[] parent = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            distance[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        distance[s] = 0;
        // parent[s] = -1;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbour : graph.get(node)) {
                if (visited[neighbour] == -1) {
                    q.add(neighbour);
                    visited[neighbour] = 1;
                    distance[neighbour] = distance[node] + 1;
                    parent[neighbour] = node;
                }
                if (parent[node] != neighbour) { // cross edge
                    if (distance[node] == distance[neighbour]) { // if they are in the same level then cycle is odd
                                                                 // length
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
