package TOP_450.GRAPHS;

import java.util.LinkedList;


@SuppressWarnings("ALL")
public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        this.V = v;
        this.adj = new LinkedList[V];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public int getV() {
        return this.V;
    }

    public LinkedList<Integer>[] getAdj() {
        return this.adj;
    }
}
