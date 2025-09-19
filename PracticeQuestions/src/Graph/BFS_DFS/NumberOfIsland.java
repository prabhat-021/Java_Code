package Graph.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] visited = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid, m, n, directions);
                }
            }
        }
        return count;
    }

    private static void bfs(int row, int col, int[][] visited, char[][] grid, int m, int n, int[][] directions) {
        visited[row][col] = 1;
        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(row, col));

        while (!qp.isEmpty()) {
            int ro = qp.peek().first;
            int co = qp.peek().second;

            qp.poll();

            for (int[] dir : directions) {
                int newRow = dir[0] + ro;
                int newCol = dir[1] + co;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                    visited[newRow][newCol] = 1;
                    qp.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
