import data_structure.Edge;
import data_structure.Graph;
import data_structure.LinkedList;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Algorithm {

    public static LinkedList<Integer> BFS(Graph graph, int start, int goal){

        boolean found = false;
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty() && !found){
            int vertex = queue.remove();
            visited[vertex] = true;
            result.add(vertex);

            LinkedList<Edge> temp = graph.getVertexEdges(vertex);
            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(e.destination);
                }
                if (e.destination == goal){
                    found = true;
                    break;
                }
            }
        }
        return result;
    }

    public static LinkedList<Integer> DFS(Graph graph, int start, int goal) {

        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()){
            int v = stack.peek();

            // the if is for making sure the values does not repeat in the result
            // if we remove it then the result will show how exactly the algorithm walk through  graph
            if(!result.contains(v)) result.add(v);
            visited[v] = true;

            var adj = graph.getVertexEdges(v);
            for(var t: adj){
                if(!visited[t.destination]){
                    stack.push(t.destination);
                    visited[t.destination] = true;
                    if (t.destination == goal) return result;
                    break;
                } else if (t == adj.getLast()) {
                    stack.pop();
                }
            }
        }
        return result;
    }

    public  static LinkedList<Integer> UCS(Graph graph, int start, int goal){
        boolean found = false;
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        PriorityQueue<Edge> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.weight > o2.weight) return 1;
                    else if (o1.weight < o2.weight) return -1;
                    return 0;
                }
        );

        queue.add(new Edge(start, 0));

        while (!queue.isEmpty() && !found){
            Edge edge = queue.remove();
            visited[edge.destination] = true;
            LinkedList<Edge> temp = graph.getVertexEdges(edge.destination);
            if(!result.contains(edge.destination))
                result.add(edge.destination);

            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(new Edge(e.destination,
                            // calculating the weight
                            // it will be the previous vertex weight + the weight of the new vertex
                            e.weight + edge.weight
                    ));
                }
                if (e.destination == goal){
                    found = true;
                    break;
                }
            }
        }
        return result;
    }

    public  static LinkedList<Integer> greedyBFS(Graph graph, int start, int goal, int[] h){
        boolean found = false;
        LinkedList<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        PriorityQueue<Edge> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.weight > o2.weight) return 1;
                    else if (o1.weight < o2.weight) return -1;
                    return 0;
                }
        );

        queue.add(new Edge(start, 0));

        while (!queue.isEmpty() && !found){
            Edge edge = queue.remove();
            visited[edge.destination] = true;
            LinkedList<Edge> temp = graph.getVertexEdges(edge.destination);
            if(!result.contains(edge.destination))
                result.add(edge.destination);

            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(new Edge(e.destination, h[e.destination]));
                }
                if (e.destination == goal){
                    found = true;
                    break;
                }
            }
        }
        return result;
    }


}
