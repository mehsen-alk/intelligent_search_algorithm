import data_structure.Graph;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile("2.txt");

        var result = Algorithm.DFS(graph, 0 , 6);

        System.out.println(result);
    }
}
