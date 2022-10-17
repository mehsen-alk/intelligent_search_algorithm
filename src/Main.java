import data_structure.Edge;
import data_structure.Graph;
import data_structure.WEdge;

public class Main {
    public static void main(String[] args) {
        Graph<Edge> g = new Graph<>(5);

        g.addEdge(0 , new Edge(3));
        g.addEdge(1 , new Edge(2));
        g.addEdge(2 , new Edge(2));
        g.addEdge(2 , new Edge(2));
        g.addEdge(2 , new Edge(2));
        g.addEdge(2 , new Edge(2));
        g.addEdge(1 , new Edge(2));
        g.addEdge(2 , new Edge(5));
        g.addEdge(1 , new Edge(1));

        System.out.println(g);
        g.toFile();
    }
}