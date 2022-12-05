package data_structure;

import java.util.Collections;

public class Graph {
    protected LinkedList<Edge>[] vertices;

    public Graph(int numberOfVertices) {
        vertices = new LinkedList[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++){
            vertices[i] = new LinkedList<>();
        }
    }

    static public Graph fromFile(String filePath){
        return GraphFileHelper.fromFile(filePath);
    }

    public int getVerticesNumber(){ return vertices.length; }

    public LinkedList<Edge> getVertexEdges(int vertex){
        LinkedList<Edge> result = vertices[vertex];
        Collections.sort(result);
        return result;
    }

    @Override
    public String toString() {
        String result = "v" + vertices.length + "\n";

        for(int i = 0; i < vertices.length; i++){
            result += i + "_ " + vertices[i].toString() + "\n";
        }

        return result;
    }
}
