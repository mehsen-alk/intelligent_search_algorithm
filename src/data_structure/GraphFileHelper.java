package data_structure;

import java.io.*;

public class GraphFileHelper {

    public static Graph fromFile(String filePath) {
        Graph graph = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            int numberOfVertices = extractNumberOfVertices(reader.readLine().replaceAll(" ", ""));
            graph = new Graph(numberOfVertices);

            for (int i = 0; i < numberOfVertices; i++){
                try {
                graph.vertices[i] = extractListOfEdge(reader.readLine().replaceAll(" ", ""), numberOfVertices);
                }
                catch (NullPointerException ignored){}
                catch (RuntimeException e){
                    System.out.println("exception found in vertex number: " + i);
                    System.out.println(e.getMessage());
                }
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("path incorrect!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }

    private static LinkedList<Edge> extractListOfEdge(String line, int numberOfVertex) {
        LinkedList<Edge> list = new LinkedList<>();
        String[] edgesAsString;

        line = line.substring(line.indexOf("_") + 1);


        edgesAsString = line.split(",");

        for (String s : edgesAsString) {
            var edge = extractEdge(s);

            if (edge.destination < numberOfVertex) {
                list.add(edge);
            } else {
                throw new RuntimeException("DESTINATION OUT OF RANGE:\n" +
                        " accepted rang is [0, " + numberOfVertex + "[ " +
                        "but found: " + edge.destination);
            }
        }

        return list;
    }

    private static Edge extractEdge(String edgeAsString) {
        Edge edge;
        // weighted graph
        if(edgeAsString.contains(":")) {
            String[] temp = edgeAsString.split(":");
            edge = new Edge(Integer.parseInt(temp[0]), Double.parseDouble(temp[1]));
        }
        // unweighted graph
        else {
            edge = new Edge(Integer.parseInt(edgeAsString), 0);
        }

        return edge;
    }

    private static int extractNumberOfVertices(String line) {
        line = line.replace("v", "0");

        return Integer.parseInt(line);
    }
}
