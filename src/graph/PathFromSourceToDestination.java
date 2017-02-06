package graph;

import java.util.*;

/**
 * Created by achalise on 6/2/17.
 * Find path from source node to destination node in a graph
 */
public class PathFromSourceToDestination {
    public int[] path(int from, int to, GraphAdjList graph) {
        int[] path = populatePath(from, to, graph);
        return path;
    }

    private int[] populatePath(int from, int to, GraphAdjList graph) {
        boolean found = false;
        int[] path = initialisePath(graph);
        List<Integer> visitedNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if(visitedNodes.contains(node)) {
                //break to avoid infinite loop, since the graph is cyclic
                break;
            } else {
                visitedNodes.add(node);
                List<Integer> children = graph.getEdgesForNode(node);
                for(Integer child: children) {
                    path[child] = node;
                    queue.add(child);
                    if(child == to) {
                        found = true;
                        break;
                    }
                }
            }
        }
        if(found) {
            Stack<Integer> nodesInPath = extractPathFromBFSTraversal(from, to, path);
            path = new int[nodesInPath.size()];
            int i = 0;
            while(!nodesInPath.empty()) {
                path[i++] = nodesInPath.pop();
            }
        } else {
            path = new int[0];
        }
        return path;
    }

    private Stack<Integer> extractPathFromBFSTraversal(int from, int to, int[] path) {
        Stack<Integer> stack = new Stack<>();
        stack.push(to);

        int throughNode = path[to];
        while(throughNode != 0) {
            stack.push(throughNode);
            throughNode = path[throughNode];
        }
        stack.push(from);
        return stack;
    }

    private int[] initialisePath(GraphAdjList graph) {
        int[] path = new int[graph.V()];
        for(int i = 0; i < path.length; i++) {
            path[i] = -1;
        }
        return path;
    }


    public static void main(String[] args) {

        GraphAdjList graph = new GraphAdjList(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        PathFromSourceToDestination pathFromSourceToDestination = new PathFromSourceToDestination();
        int from = 0;
        int to = 5;
        int[] path = pathFromSourceToDestination.path(from, to, graph);
        System.out.println("Path " + from + " to " + to);
        for(int node: path) {
            System.out.print(node + " -> ");
        }
    }
}
