package graph;


import java.util.Stack;

/**
 * Created by achalise on 3/2/17.
 */
public class CourseSchedule {
    private Graph<Integer> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new Graph<>();

        for(int i = 0; i < prerequisites.length; i++) {
            graph.addEdge(new Vertex(prerequisites[i][0], 0), new Vertex(prerequisites[i][1], 0));
        }
        System.out.println(graph);
        return topologicalSort(graph);
    }

    private int[] topologicalSort(Graph<Integer> graph) {
        Stack<Integer> visitedNodes = new Stack<>();
        for(Vertex<Integer> vertex : graph.getALlVertices()) {
            if(!visitedNodes.contains(vertex.getId())) {
                System.out.println("Visiting node: " + vertex.getId());
                dfs(vertex, visitedNodes);
            }
        }
        while(!visitedNodes.empty()) {
            System.out.println(visitedNodes.pop() + "->");
        }
        return null;
    }

    private void dfs(Vertex<Integer> vertex, Stack<Integer> visitedNodes) {
        if(!visitedNodes.contains(vertex.getId())) {
            visitedNodes.push(vertex.getId());
        }

        for(Edge<Integer> edge: vertex.getEdges()) {
            dfs(edge.getTo(), visitedNodes);
        }
    }


    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.findOrder(4, new int[][]{{1,0}, {2,0}, {3,0}, {3,3}});
    }

}
