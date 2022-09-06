package TOP_450.GRAPHS;

import java.util.LinkedList;

/*
        Problem- https://www.geeksforgeeks.org/check-given-graph-tree
        Write a function that returns true if a given undirected graph is tree and false otherwise

        Given n nodes labeled from 0 to n-1 and list of undirected edges (each edge is a pair of nodes), write
        a function to check whether these edges make a valid tree.

        An undirected graph is tree if it has the following properties:
          1) Empty graph is a valid tree.
          2) There is no cycle.
          3) The graph is connected.

        Input: n=5, edges=[ [0,1] , [0,2], [0,3], [1,4] ]

        How to detect cycle in an undirected graph?
                We can either use BFS or DFS. For every visited vertex ‘v’,
                if there is an adjacent ‘u’ such that u is already visited and u is not parent of v,
                then there is a cycle in graph. If we don’t find such an adjacent for any vertex,
                we say that there is no cycle.

        How to check for connectivity?
                Since the graph is undirected, we can start BFS or DFS from any vertex and
                check if all vertices are reachable or not. If all vertices are reachable, then graph is connected, otherwise not.

        Time Complexity: O(V + E) For performing the DFS traversal
        Auxiliary Space: O(V) For storing the visited array
 */
@SuppressWarnings("ALL")
public class GraphValidTree178 {

    boolean isCyclicUtil(Graph graph, int v, boolean[] visited, int parent) {
        // Mark the current node as visited
        visited[v] = true;
        LinkedList<Integer> edges = graph.getAdj()[v];

        // Recur for all the vertices adjacent to this vertex in DFS manner
        for (int i = 0; i < edges.size(); i++) {

            // If an adjacent is not visited, then recur for that adjacent
            // current vertex v is parent for all its adjacent vertices present in adj[v] list
            if (!visited[edges.get(i)]) {
                if (isCyclicUtil(graph, edges.get(i), visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of
            // current vertex, then there is a cycle.
            else if (edges.get(i) != parent)
                return true;
        }
        return false;
    }

    boolean isTree(Graph graph) {

        boolean[] visited = new boolean[graph.getV()];
        for (int u = 0; u < graph.getV(); u++)
            visited[u] = false;

        // The call to isCyclicUtil serves multiple purposes.
        //  - It returns true if graph reachable from vertex 0 is cyclic.
        //  - It also marks all vertices reachable from 0.
        if (isCyclicUtil(graph, 0, visited, -1)) {
            return false;
        }

        // If we find a vertex which is not reachable from 0
        // (not marked by isCyclicUtil(), then we return false
        for (int u = 0; u < graph.getV(); u++)
            if (!visited[u])
                return false;

        return true;
    }


    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if (new GraphValidTree178().isTree(g1))
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);

        if (new GraphValidTree178().isTree(g2))
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
    }
}
