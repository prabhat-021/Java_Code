import java.util.ArrayList;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
//        Queen(board, 0, n);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        Queen(board, 0, n, ans);
        return ans;
    }

    public static void Queen(boolean[][] board, int row, int tq, List<List<String>> ans) {
        if (tq == 0) {
            List<String> ll = new ArrayList<>();
            display(board, ll);
            ans.add(new ArrayList<>(ll));
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                Queen(board, row + 1, tq - 1, ans);
                board[row][col] = false;
            }
        }

    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        int r = row;
        while (r >= 0) {
            if (board[r][col]) {
                return false;
            }
            r--;
        }

        r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public static void display(boolean[][] ans, List<String> ll) {
        for (int i = 0; i < ans.length; i++) {
            String s = "";
            for (int j = 0; j < ans[0].length; j++) {
                if (ans[i][j]) s += "Q";
                else s += ".";
//                System.out.print(ans[i][j] + " ");
            }
            ll.add(s);
//            System.out.println();
        }
    }
}
