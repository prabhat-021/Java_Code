
public class N_Queen {
    public static void main(String[] args) {

    }

    public static void Queen(boolean[][] board, int row, int tq) {
        if (tq == 0) {
            display(board);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                Queen(board, row + 1, tq - 1);
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
            if (board[r][col]) {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r >= 0 && c <= board[0].length) {
            if (board[r][col]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public static void display(boolean[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }
}
