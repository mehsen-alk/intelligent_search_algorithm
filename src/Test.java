import data_structure.Graph;

import java.util.Arrays;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile();

        int[] result = Algorithm.BFS(graph, 0 , 2);

        System.out.println(Arrays.toString(result));
    }
}
