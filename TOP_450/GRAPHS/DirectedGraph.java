package TOP_450.GRAPHS;

import java.util.LinkedList;

public class DirectedGraph {
    private int V;
    private LinkedList<Integer>[] adj;

    public DirectedGraph(int v) {
        this.V = v;
        this.adj = new LinkedList[V];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void print() {
        for (int i = 0; i < this.V; i++) {
            System.out.println("vertex " + i + " adjacency list " + this.getAdj()[i]);
        }
    }

    public int getV() {
        return this.V;
    }

    public LinkedList<Integer>[] getAdj() {
        return this.adj;
    }
}
