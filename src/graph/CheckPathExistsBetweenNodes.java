package graph;

import java.security.DigestException;
import java.util.*;

/**
 * Created by achalise on 14/2/17.
 */
public class CheckPathExistsBetweenNodes {



    public static void main(String[] args) {
        DiGraph graph = new DiGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        graph.addPath(1, 2);
        graph.addPath(2, 4);
        graph.addPath(2, 5);
        graph.addPath(3, 5);

    }
}

class DiGraph {
    Map<Integer, GraphNode>  nodes;
    public DiGraph() {
        this.nodes = new HashMap<>();
    }
    public void addNode(int node) {
        nodes.put(node, new GraphNode(node));
    }

    public int size() {
        return this.nodes.size();
    }

    public void addPath(int n1, int n2) {
        GraphNode n = nodes.get(n1);
        if(n == null) {
            nodes.put(n1, new GraphNode(n1));
        }
        n = nodes.get(n2);
        if(n == null) {
            nodes.put(n2, new GraphNode(n2));
        }
        nodes.get(n1).addNeighbour(nodes.get(n2));
    }

    public int[] pathBetweenNodes(int n1, int n2) {
        int[] path = new int[this.size()];
        GraphNode node = nodes.get(n1);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode n = queue.poll();

            queue.addAll(n.getNeighbours());

        }
        return null;
    }
}
class GraphNode {
    int value;
    List<GraphNode> nodes;

    public GraphNode(int value) {
        this.value = value;
        this.nodes = new ArrayList<>();
    }

    public void addNeighbour(GraphNode node) {
        this.nodes.add(node);
    }

    public List<GraphNode> getNeighbours() {
        return this.nodes;
    }
}
