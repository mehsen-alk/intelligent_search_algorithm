import data_structure.Graph;

import java.util.Scanner;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile("4.txt");
        System.out.println(graph);
        System.out.println(Algorithm.BFS(graph, 0, 12));
    }
}
