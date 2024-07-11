
static Boolean can_be_completed(Integer n, ArrayList<Integer> a, ArrayList<Integer> b) {
    // check the acyclic property - if cyclic then it is not valid
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    // populate the graph - directed
    for (int i = 0; i < a.size(); i++) {
        graph.get(a.get(i)).add(b.get(i));
    }

    int[] visited = new int[n];
    for (int i = 0; i < n; i++) {
        visited[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        if (visited[i] == 0) {
            if (!is_acyclic(graph, i, visited)) {
                return false;
            }
        }
    }
    return true;
}

static boolean is_acyclic(ArrayList<ArrayList<Integer>> graph, int s, int[] visited) {
    // base cases
    if (visited[s] == 1) {
        return false;
    }
    if (visited[s] == 2) {
        return true;
    }

    visited[s] = 1; // we are visiting this node

    // recursive cases
    for (int neighbour : graph.get(s)) {
        if (!is_acyclic(graph, neighbour, visited)) {
            return false;
        }
    }

    visited[s] = 2; // we are done visiting

    return true;
}
