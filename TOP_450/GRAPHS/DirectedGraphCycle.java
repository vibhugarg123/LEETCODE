package TOP_450.GRAPHS;

import java.util.ArrayList;
import java.util.List;

/*
    https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
    Cycle in a Directed Graph
    Using DFS - O(V + E) Time and O(V) Space
 */
public class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(V);
        boolean[] visited = new boolean[V];
        boolean[] path = new boolean[V];
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
            visited[i] = false;
            path[i] = false;
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, path)) return true;
            }
        }
        return false;
    }

    private boolean dfs(List<List<Integer>> graph, int source, boolean[] visited, boolean[] path) {
        visited[source] = true;
        path[source] = true;

        for (Integer i : graph.get(source)) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, path)) {
                    return true;
                }
            } else if (visited[i] && path[i]) {
                return true;
            }

        }
        // unset path[source] after the DFS call finishes for that node, not for its child.
        path[source] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        DirectedGraphCycle directedGraphCycle = new DirectedGraphCycle();
        System.out.println(directedGraphCycle.isCyclic(V, edges));
    }
}
