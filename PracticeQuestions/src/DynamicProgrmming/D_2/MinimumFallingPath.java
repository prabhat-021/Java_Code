package DynamicProgrmming.D_2;

public class MinimumFallingPath {
    public static void main(String[] args) {

    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if (j - 1 >= 0) left = matrix[i][j] + dp[i - 1][j - 1];
                if (j + 1 < n) right = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(left, Math.min(right, up));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    }
}
