package graph;

public class MainGraph {

    public static void main(String[] args) {
        MyGraphList m = new MyGraphList(5);
        m.addEdge(1,2);
        m.addEdge(4,3);
        m.addEdge(1,3);
        m.printGraph();
    }
}
