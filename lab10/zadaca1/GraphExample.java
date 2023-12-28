package zadaca1;

import java.util.*;

class AdjacencyListGraph<T> {
    private final Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }


    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }


    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }


    public void removeEdge(T source, T destination) {
        adjacencyList.getOrDefault(source, Collections.emptySet()).remove(destination);
        adjacencyList.getOrDefault(destination, Collections.emptySet()).remove(source);
    }

    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptySet());
    }

    public void print() {
        adjacencyList.forEach((vertex, neighbors) ->
                System.out.printf("%s: %s\n", vertex.toString(), new ArrayList<>(neighbors)));
    }
}

public class GraphExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            switch (parts[0]) {
                case "CREATE":
                    graph = new AdjacencyListGraph<>();
                    break;
                case "PRINTGRAPH":
                    graph.print();
                    System.out.println();
                    break;
                case "ADDEDGE":
                    graph.addEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                case "DELETEEDGE":
                    graph.removeEdge(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    break;
                default:
                    System.out.println(graph.getNeighbors(Integer.parseInt(parts[1]))
                            .contains(Integer.parseInt(parts[2])));
                    break;
            }
        }

        scanner.close();
    }
}
