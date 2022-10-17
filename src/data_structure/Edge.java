package data_structure;

public class Edge implements EdgeInterface{
    int vertex;

    public Edge(int vertex) {
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "" + vertex;
    }
}
