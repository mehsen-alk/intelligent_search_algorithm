package data_structure;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    public int destination;
    public double weight;

    public Edge(int destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return destination + ":" + weight ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return destination == edge.destination && Double.compare(edge.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, weight);
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(destination, e.destination);
    }
}
