package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achalise on 6/2/17.
 */
class GraphAdjList {
    private int V; //no of vertices
    private int E; //no of edges
    private List<Integer>[] edges;

    public int V () {
        return this.V;
    }

    public  GraphAdjList(int size) {
        this.V = size;
        this.edges = new List[size];
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        this.edges[from].add(to);
        E++;
    }

    public List<Integer> getEdgesForNode(int node) {
        return this.edges[node];
    }

}
