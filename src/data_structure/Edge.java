package data_structure;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    public int destination;
    public double wight;

    public Edge(int destination, double wight) {

        this.destination = destination;
        this.wight = wight;
    }

    @Override
    public String toString() {
        return destination + ":" + wight ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return destination == edge.destination && Double.compare(edge.wight, wight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, wight);
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(destination, e.destination);
    }
}
