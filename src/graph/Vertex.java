package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    private int id;
    private T data;
    private List<Edge> edges;

    public Vertex(int id, T data) {
        this.id = id;
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    public int getId() {
        return id;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
