import data_structure.Edge;
import data_structure.Graph;
import data_structure.LinkedList;

import java.util.Queue;

public class Algorithm {

    public static int[] BFS(Graph graph, int start, int goal){

        int resIndex = 0;
        boolean found = false;
        int[] result = new int[graph.getVerticesNumber()];
        boolean[] visited = new boolean[graph.getVerticesNumber()];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < graph.getVerticesNumber(); i++)
            result[i] = -1;


        queue.add(start);
        result[resIndex++] = start;
        visited[start] = true;

        while (!queue.isEmpty() && !found){
            int vertex = queue.remove();
            LinkedList<Edge> temp = graph.getVertexEdges(vertex);
            for (Edge e : temp) {
                if (!visited[e.destination]) {
                    queue.add(e.destination);
                    visited[e.destination] = true;
                    result[resIndex++] = e.destination;
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
