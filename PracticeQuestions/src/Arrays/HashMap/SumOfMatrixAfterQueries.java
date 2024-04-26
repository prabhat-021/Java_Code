package Arrays.HashMap;

public class SumOfMatrixAfterQueries {
    public static void main(String[] args) {

    }

    public static long matrixSumQueries(int n, int[][] queries) {
        int countRows = 0, countColoums = 0;
        boolean[] rowSeen = new boolean[n];
        boolean[] colSeen = new boolean[n];
        long sum = 0;
        for (int qr = queries.length - 1; qr >= 0; qr--) {
            int type = queries[qr][0], index = queries[qr][1], val = queries[qr][2];
            if (type == 0 && !colSeen[index]) {
                countColoums++;
                colSeen[index] = true;
                sum += (n - countRows) * val;
            }
            if (type == 1 && !rowSeen[index]) {
                countRows++;
                rowSeen[index] = true;
                sum += (n - countColoums) * val;
            }
        }
        return sum;
    }
}
