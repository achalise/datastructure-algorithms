package graph;

import java.util.*;

/**
 * Created by achalise on 2/2/17.
 */
public class Graph<T> {
    private Map<Integer, Vertex<T>> vertices;
    private List<Edge<T>> edges;

    public Graph() {
        vertices = new HashMap<>();
        edges = new ArrayList<>();
    }


    public Collection<Vertex<T>> getALlVertices() {
        return vertices.values();
    }

    public void addVertex(Vertex<T> vertex) {
        if(vertices.get(vertex.getId()) == null) {
            vertices.put(vertex.getId(), vertex);
        } else {
            System.out.println("Vertex " + vertex.getId() + " already exists in the graph.");
        }
    }

    public void addEdge(Vertex from, Vertex to) {
        vertices.putIfAbsent(from.getId(), from);
        vertices.putIfAbsent(to.getId(), to);

        Edge edge = new Edge(from, to);
        edges.add(edge);
        vertices.get(from.getId()).getEdges().add(edge);
    }

    public void removeEdge(int from, int to) {
        //not implemented yet
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vertices: \t Edges \n");
        for(Vertex vertex : vertices.values()) {
            stringBuilder.append(vertex.getId()).append("\t\t");
            List<Edge> edges = vertex.getEdges();
            for(Edge edge: edges) {
                stringBuilder.append(edge).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(new Vertex(0, 0), new Vertex(1, 10));
        graph.addEdge(new Vertex(0, 0), new Vertex(2, 5));
        graph.addEdge(new Vertex(2, 5), new Vertex(3, 10));
        System.out.println(graph);
    }
}

