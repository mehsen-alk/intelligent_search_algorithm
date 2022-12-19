import data_structure.Graph;

import java.util.Scanner;

public class Test {
    public static void main(String []arg){
        Scanner in = new Scanner(System.in);
        Graph graph = Graph.fromFile("input.txt");
        System.out.println(graph);
        System.out.println(Algorithm.BFS(graph, 0, 12));
    }
}
