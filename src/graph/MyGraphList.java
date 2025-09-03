package graph;

import java.util.ArrayList;
import java.util.List;

public class MyGraphList {
    private int v;
    private List<Integer>[] adjList;

    MyGraphList(int v) {
        this.v = v;
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.println(i + "-> " + adjList[i]);
        }
    }
}
