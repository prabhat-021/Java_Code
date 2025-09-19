package Graph.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {

    }

    public class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] visited = new int[m][n];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (visited[i][j] == 0 && board[i][j] == 'O') {
                        dfs(board, i, j, visited, directions);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1 && board[i][j] != 'X') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col, int[][] visited, int[][] directions) {
        Queue<Pair> qp = new LinkedList<>();
        qp.add(new Pair(row, col));

        while (!qp.isEmpty()) {
            Pair rv = qp.poll();
            int r = rv.row;
            int c = rv.col;

            visited[r][c] = 1;
            for (int[] dir : directions) {
                int newRow = dir[0] + r;
                int newCol = dir[1] + c;

                if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && visited[newRow][newCol] == 0 && board[newRow][newCol]=='O') {
                    visited[newRow][newCol] = 1;
                    qp.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
