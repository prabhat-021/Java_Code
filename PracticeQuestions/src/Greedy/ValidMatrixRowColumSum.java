package Greedy;

public class ValidMatrixRowColumSum {
    public static void main(String[] args) {

    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int colum = colSum.length;
        int[][] ans = new int[rows][colum];

        int i = 0, j = 0;
        while (i < rows && j < colum) {
            int value = Math.min(rowSum[i], colSum[j]);
            ans[i][j] = value;
            rowSum[i] -= value;
            colSum[j] -= value;

            if (rowSum[i] == 0) i++;
            if (colSum[j] == 0) j++;
        }

        return ans;
    }
}
