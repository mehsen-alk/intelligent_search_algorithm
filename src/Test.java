import data_structure.Graph;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile("3.txt");
        System.out.println("ucs: " + Algorithm.UCS(graph, 0, 4));
        System.out.println("greedy bfs: " + Algorithm.greedyBFS(graph, 0, 4, new int[]{1, 2, 9, 4, 5, 1}));
    }
}
