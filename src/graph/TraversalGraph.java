package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalGraph {


    void bfs(int start, List<Integer>[] graph) {
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int n : graph[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
    }

    void dfs(int node, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int n : graph[node]) {
            if (!visited[n]) {
                dfs(n, visited, graph);
            }
        }
    }
}
