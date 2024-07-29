package DynamicProgrmming.Partition;

public class MatrixChainMultiplication {
    public static void main(String[] args) {

    }

    public int matMul(int[] arr, int n) {
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][n - 1];

//        return f(1, n - 1, arr);
    }

    public int f(int i, int j, int[] arr) {
        if (i == j) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + f(i, k, arr) + f(k + 1, j, arr);
            min = Math.min(min, steps);
        }

        return min;
    }
}
