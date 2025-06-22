package TOP_450.GRAPHS;

import java.util.*;

/*
    https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    Do undirected graph BFS traversal
    Complexity Analysis of Breadth-First Search (BFS) Algorithm

    Time Complexity: O(V + E), BFS explores all the vertices and edges in the graph.
        In the worst case, it visits every vertex and edge once.
        Therefore, the time complexity of BFS is O(V + E),
        where V and E are the number of vertices and edges in the given graph.

    Auxiliary Space: O(V),
        BFS uses a queue to keep track of the vertices that need to be visited.
        In the worst case, the queue can contain all the vertices in the graph.
        Therefore, the space complexity of BFS is O(V).
 */
public class BFS {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (adj.isEmpty()) return result;

        int nVertices = adj.size();

        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[nVertices];

        Q.add(0);
        visited[0] = true;

        while (!Q.isEmpty()) {
            Integer current = Q.poll();
            result.add(current);

            ArrayList<Integer> adjacentNodes = adj.get(current);
            for (Integer x : adjacentNodes) {
                if (!visited[x]) {
                    visited[x] = true;
                    Q.add(x);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        ArrayList<Integer> l1 = new ArrayList<>(List.of(2, 3, 1));
        ArrayList<Integer> l2 = new ArrayList<>(List.of(0));
        ArrayList<Integer> l3 = new ArrayList<>(List.of(0, 4));
        ArrayList<Integer> l4 = new ArrayList<>(List.of(0));
        ArrayList<Integer> l5 = new ArrayList<>(List.of(2));

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(List.of(l1, l2, l3, l4, l5));
        bfs.bfs(graph);
    }

}
