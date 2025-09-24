package Graph.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle {
    public static void main(String[] args) {

    }

    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, V, adj, visited)) return true;
            }
        }

        return false;
    }

    public boolean detectCycle(int src, int V, List<List<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(src, -1));
        while (!qp.isEmpty()) {
            Pair rv = qp.poll();
            int node = rv.src;
            int parent = rv.dest;

            for (int adjust : adj.get(node)) {
                if (!visited[adjust]) {
                    visited[adjust] = true;
                    qp.add(new Pair(adjust, node));
                } else if (parent != adjust) {
                    return true;
                }
            }
        }
        return false;
    }

    public class Pair {
        int src;
        int dest;

        Pair(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
}
