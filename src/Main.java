import data_structure.Graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph = null;
        Scanner in = new Scanner(System.in);
        int choice;
        boolean end = false;

        while (!end){
            while(graph == null){
                    System.out.print("enter the file path to extract the graph from it\n" +
                            "file path: ");
                    graph = Graph.fromFile(in.next());
            }

            System.out.print("\t\t\t---command list---\n" +
                    "1_ delete graph\n" +
                    "2_ BFS\n" +
                    "3_ DFS\n" +
                    "4_ UCS\n" +
                    "0_ exit\n" +
                    "your choice: ");
            try {
            choice = in.nextInt();
            }catch (Exception e){
                System.out.println("bad input!");
                continue;
            }

            switch (choice) {
                case 0 -> end = true;
                case 1 -> graph = null;
                case 2, 3, 4 -> {
                    System.out.print("enter the starting node: ");
                    int start = in.nextInt();
                    System.out.print("enter the goal node: ");
                    int goal = in.nextInt();
                    switch (choice) {
                        case 2 -> System.out.println(Algorithm.BFS(graph, start, goal));
                        case 3 -> System.out.println(Algorithm.DFS(graph, start, goal));
                        case 4 -> System.out.println(Algorithm.UCS(graph, start, goal));
                    }
                }
                default -> System.out.println("wrong input!");
            }
        }
    }
}