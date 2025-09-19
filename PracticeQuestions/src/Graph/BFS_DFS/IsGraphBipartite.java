package Graph.BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colour = new int[len];
        Arrays.fill(colour, -1);

        for (int i = 0; i < len; i++) {
            if (colour[i] == -1 && !ValidCheck(graph, colour, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean ValidCheck(int[][] graph, int[] colour, int start) {
        Queue<Integer> qp = new LinkedList<>();
        qp.add(start);
        colour[start] = 0;

        while (!qp.isEmpty()) {
            int node = qp.poll();
            for (int it : graph[node]) {
                if (colour[it] == -1) {
                    colour[it] = 1 - colour[node];
                    qp.add(it);
                } else if (colour[it] == colour[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
