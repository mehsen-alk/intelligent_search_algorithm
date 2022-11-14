import data_structure.Graph;

public class Test {
    public static void main(String []arg){
        Graph graph = Graph.fromFile("3.txt");

        var result = Algorithm.UCS(graph, 0 , 4);

        System.out.println(result);
    }
}
