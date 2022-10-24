import data_structure.Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = null;
        Scanner in = new Scanner(System.in);
        int choice;
        boolean end = false;

        while(!end){
        System.out.print("command list: \n" +
                "1: read graph from file \n" +
                "2: print graph \n" +
                "3: write graph to file \n" +
                "0: exit \n" +
                "your choice: ");
        choice = in.nextInt();

        switch (choice){
            case 1:
                System.out.print("input.txt? \n" +
                        "1: yes \n" +
                        "2: no \n");
                if(in.nextInt() == 1){
                    graph = Graph.fromFile();
                    System.out.println("done\n");
                }else {
                    System.out.println("inter file path: ");
                    String path = in.next();
                    graph = Graph.fromFile(path);
                    System.out.println("done\n");
                }
                break;

            case 2:
                System.out.println(graph);
                System.out.println("done\n");
                break;

            case 3:
                System.out.print("output.txt? \n" +
                        "1: yes \n" +
                        "2: no \n");
                if(in.nextInt() == 1){
                    graph.toFile();
                    System.out.println("done\n");
                }else {
                    System.out.println("inter file path: ");
                    String path = in.next();
                    graph.toFile(path);
                    System.out.println("done\n");
                }
                break;

            case 0:
                end = true;
                break;

            default:
                System.out.println("wrong input!\n");
        }
        }
    }
}