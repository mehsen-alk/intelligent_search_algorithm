import data_structure.Edge;
import data_structure.Graph;
import data_structure.LinkedList;

import java.util.Comparator;
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
        result.add(start);
        visited[start] = true;

        while (!queue.isEmpty() && !found){
            int vertex = queue.remove();
            LinkedList<Edge> temp = graph.getVertexEdges(vertex);
            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(e.destination);
                    visited[e.destination] = true;
                    result.add(e.destination);
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
        result.add(start);
        visited[start] = true;

        while (!stack.isEmpty()){
            int v = stack.peek();
            var adj = graph.getVertexEdges(v);
            for(var t: adj){
                if(!visited[t.destination]){
                    stack.push(t.destination);
                    result.add(t.destination);
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
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(
                new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        if (o1.wight > o2.wight) return 1;
                        else if (o1.wight < o2.wight) return -1;
                        return 0;
                    }
                }
        );

        queue.add(new Edge(start, 0));
        result.add(start);

        while (!queue.isEmpty() && !found){
            Edge edge = queue.remove();
            visited[edge.destination] = true;
            LinkedList<Edge> temp = graph.getVertexEdges(edge.destination);
            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(new Edge(e.destination, e.wight + edge.wight));
                    result.add(e.destination);
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
