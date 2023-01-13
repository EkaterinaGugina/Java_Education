package HomeWork_27_12_22;

public class Main {
    
    public static void main(String[] args) {
        testBfs();
    }

    private static void testBfs() {
        Pathgraph graph = new Pathgraph(8);
        graph.addPoint("A");
        graph.addPoint("B");
        graph.addPoint("C");
        graph.addPoint("D");
        graph.addPoint("E");
        graph.addPoint("F");
        graph.addPoint("G");
        graph.addPoint("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }
}
