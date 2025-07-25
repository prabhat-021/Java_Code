package Graph.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                num++;
                bfs(isConnected, visited, i, n);
            }
        }
        return num;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int curr, int nodes) {
        visited[curr] = true;
        for (int i = 0; i < nodes; i++) {
            if (curr != i && isConnected[curr][i] == 1 && !visited[i]) {
                bfs(isConnected, visited, i, nodes);
            }
        }
    }
}
