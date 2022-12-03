import data_structure.Graph;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile("3.txt");
        System.out.println("bfs: " + Algorithm.UCS(graph, 0, 4));
    }
}
