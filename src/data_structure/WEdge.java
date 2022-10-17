package data_structure;

public class WEdge implements EdgeInterface{
    int vertex;
    int wight;

    public WEdge(int vertex, int wight) {
        this.vertex = vertex;
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "" + vertex + ":" + wight;
    }
}
