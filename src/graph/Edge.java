package graph;

public class Edge<T> {
    private Vertex<T> from;
    private Vertex<T> to;

    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public void setFrom(Vertex<T> from) {
        this.from = from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public void setTo(Vertex<T> to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return from.getId() + " -> " + to.getId();
    }
}
