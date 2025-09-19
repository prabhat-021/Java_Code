package Graph.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public static void main(String[] args) {

    }

    public class TriPair {
        int row;
        int col;
        int steps;

        public TriPair(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        Queue<TriPair> qp = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    qp.add(new TriPair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!qp.isEmpty()) {
            TriPair rv = qp.poll();
            int ro = rv.row;
            int co = rv.col;
            int steps = rv.steps;

            distance[ro][co] = steps;

            for (int[] dir : directions) {
                int newRow = dir[0] + ro;
                int newCol = dir[1] + co;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    qp.add(new TriPair(newRow, newCol, steps + 1));
                }
            }
        }
        return distance;
    }
}
