package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by achalise on 5/2/17.
 */
public class GraphTraversal {

    /**
     *
     * @param graph
     * @return true if the graph has cycle
     */
    public boolean hasCycle(GraphAdjList graph) {
        return dfs(graph);
    }

    public boolean dfs(GraphAdjList graph) {
        boolean hasCycle = false;
        List<Integer> visited = new ArrayList<>();
        for(int node = 0; node < graph.V(); node++) {
            if(!visited.contains(node)) {
                hasCycle = dfs(node, graph, visited);
                if(hasCycle) {
                    return true;
                }
            }
        }
        return hasCycle;

    }

    private boolean dfs(int node, GraphAdjList graph, List<Integer> visitedNodes) {
        System.out.println(" -> " + node);
        visitedNodes.add(node);
        List<Integer> children = graph.getEdgesForNode(node);
        for(Integer child: children) {
            if(!visitedNodes.contains(child)) {
                return dfs(child, graph, visitedNodes);
            } else {
                return true;
            }
        }
        return false;
    }

    public void bfs(GraphAdjList graph) {
        List<Integer> visitedNodes = new ArrayList<>();
        for(int node = 0; node < graph.V(); node++) {
            bfs(node, graph, visitedNodes);
        }
    }

    private void bfs(int node, GraphAdjList graph, List<Integer> visitedNodes) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if(!visitedNodes.contains(n)) {
                System.out.println("-> " + n);
                visitedNodes.add(n);
                queue.addAll(graph.getEdgesForNode(n));
            }
        }

    }

    public static void main(String[] args) {
        GraphAdjList graphAdjList = new GraphAdjList(4);
        graphAdjList.addEdge(0, 1);
        graphAdjList.addEdge(0, 2);
        graphAdjList.addEdge(1, 3);


        GraphTraversal traversal = new GraphTraversal();
        traversal.dfs(graphAdjList);
        System.out.println(" ------- BFS");
        traversal.bfs(graphAdjList);
        System.out.println("The graph has cycle: " + traversal.hasCycle(graphAdjList));
        graphAdjList.addEdge(3, 0);
        System.out.println("The graph has cycle: " + traversal.hasCycle(graphAdjList));
    }

}

