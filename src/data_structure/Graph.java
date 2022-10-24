package data_structure;



public class Graph {
    protected LinkedList<Edge>[] vertices;

    /**
     * create new graph with fixed number of vertex
     * @param numberOfVertices
     */
    public Graph(int numberOfVertices) {
        vertices = new LinkedList[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++){
            vertices[i] = new LinkedList<>();
        }
    }

    static public Graph fromFile(){
        return fromFile("input.txt");
    }

    static public Graph fromFile(String filePath){
        return GraphFileHelper.fromFile(filePath);
    }

    public void addEdge(int source, int destination, double wight) {
        if (source >= vertices.length)
            throw new RuntimeException("\n\nSOURCE OUT OF RANGE: " +
                    "the range is [0," + vertices.length + "[\n " +
                    "source was: " + source + "\n\n");

        if (destination >= vertices.length)
            throw new RuntimeException("\n\nDESTINATION OUT OF RANGE: " +
                    "the range is [0," + vertices.length + "] " +
                    "destination was: " + destination + "\n\n");

        vertices[source].add(new Edge(destination, wight));
    }

    public void removeEdge(int source, int destination, double wight){
        if (source < vertices.length && destination < vertices.length) {
            vertices[source].remove(new Edge(destination, wight));
        }
    }

    @Override
    public String toString() {
        String result = "v" + vertices.length + "\n";

        for(int i = 0; i < vertices.length; i++){
            result += i + "_ " + vertices[i].toString() + "\n";
        }

        return result;
    }

    public void toFile(){
        toFile("output.txt");
    }

    public void toFile(String filePath){
        GraphFileHelper.toFile(this, filePath);
    }
}
