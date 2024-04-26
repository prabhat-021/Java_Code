public class Queen_Permutation {
    public static void main(String[] args) {
        int n = 4;
        int tq = 2;
        boolean[] board = new boolean[n];
//        permutation(board, tq, 0, "");
        combination(board, tq, 0, "", 0);
    }

    public static void permutation(boolean[] board, int tq, int qpsf, String ans) {
        if (tq == qpsf) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] == false) {
                board[i] = true;
                permutation(board, tq, qpsf + 1, ans + "b" + i + "q" + qpsf);
//                this is back tracking ;
//                this is undoing the work done by the recursion
                board[i] = false;
            }
        }
    }

    public static void combination(boolean[] board, int tq, int qpsf, String ans, int idx) {
        if (tq == qpsf) {
            System.out.println(ans);
            return;
        }

        for (int i = idx; i < board.length; i++) {
            if (board[i] == false) {
                board[i] = true;
                combination(board, tq, qpsf + 1, ans + "b" + i + "q" + qpsf, i + 1);
//                this is back tracking ;
//                this is undoing the work done by the recursion
                board[i] = false;
            }
        }
    }
}
