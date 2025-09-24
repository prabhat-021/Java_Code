package Graph.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

    }

    public static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> qp = new LinkedList<>();
        int[][] visited = new int[m][n];
        int countFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    qp.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }

        int tm = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!qp.isEmpty()) {
            Pair rv = qp.poll();
            int row = rv.row;
            int col = rv.col;
            tm = Math.max(rv.time, tm);

            for (int[] dir : directions) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    qp.add(new Pair(newRow, newCol, tm + 1));
                    visited[newRow][newCol] = 2;
                    countFresh--;
                }
            }
        }

        if (countFresh != 0) return -1;

        return tm;
    }
}
