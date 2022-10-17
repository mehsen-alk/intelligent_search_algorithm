package data_structure;

import java.io.*;


/**
 *  T can be ether [Edge] or [WEdge]
 * <p>
 *  first vertex will be 0 and the last one will be [numberOfVertex - 1]
 * </p>
 */
public class Graph<T extends EdgeInterface> {
    LinkedList<T>[] vertexes;

    public Graph(int numberOfVertex){
        vertexes = (LinkedList<T>[]) new LinkedList[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++){
            vertexes[i] = new LinkedList<T>();
        }
    }

    public void addEdge(int vertex, T value){
        vertexes[vertex].add(value);
    }

    public void removeEdge(int vertex, T value){
        vertexes[vertex].remove(value);
    }

    @Override
    public String toString() {
        String result = "";

        for(int i = 0; i < vertexes.length; i++){
            result += ( i + " _ " + vertexes[i] + "\n");
        }
        return result;
    }

    public void toFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output,txt"));
            String wEdge = "";
            if(vertexes[0].getFirst() instanceof WEdge)
                wEdge = "w";
            writer.write("v " + vertexes.length + " " + wEdge + "\n");
            writer.write(this.toString());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

