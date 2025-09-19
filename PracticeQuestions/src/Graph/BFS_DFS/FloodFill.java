package Graph.BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {

    }

    public static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int old = grid[sr][sc];
        grid[sr][sc] = visited[sr][sc] = color;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(sr, sc));

        while (!qp.isEmpty()) {
            Pair rv = qp.poll();
            int row = rv.row;
            int col = rv.col;

            for (int[] dir : directions) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0
                        && grid[newRow][newCol] == old) {
                    qp.add(new Pair(newRow, newCol));
                    visited[newRow][newCol] = -1;
                    grid[newRow][newCol] = color;
                }
            }
        }
        return grid;
    }
}
