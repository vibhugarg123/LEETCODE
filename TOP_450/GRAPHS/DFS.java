package TOP_450.GRAPHS;

import java.util.ArrayList;
import java.util.List;


/*
    DFS of Graph: https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    Time complexity: O(V + E),
    where V is the number of vertices and E is the number of edges in the graph.
    Auxiliary Space: O(V + E),
    since an extra visited array of size V is required,
    And stack size for recursive calls to dfsUtils function.
 */
public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (adj.isEmpty()) return result;

        dfsUtils(adj, 0, new boolean[adj.size()], result);
        return result;
    }

    public void dfsUtils(ArrayList<ArrayList<Integer>> adj, Integer source, boolean[] visited, ArrayList<Integer> result) {
        visited[source] = true;
        result.add(source);

        for (Integer x : adj.get(source)) {
            if (!visited[x]) {
                dfsUtils(adj, x, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        ArrayList<Integer> l1 = new ArrayList<>(List.of(2, 3, 1));
        ArrayList<Integer> l2 = new ArrayList<>(List.of(0));
        ArrayList<Integer> l3 = new ArrayList<>(List.of(0, 4));
        ArrayList<Integer> l4 = new ArrayList<>(List.of(0));
        ArrayList<Integer> l5 = new ArrayList<>(List.of(2));

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(List.of(l1, l2, l3, l4, l5));
        dfs.dfs(graph);
    }
}
