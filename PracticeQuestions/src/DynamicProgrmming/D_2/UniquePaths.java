package DynamicProgrmming.D_2;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0, left = 0;

                if (i > 0) up = dp[i - 1][j];
                if (j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

//    private void findPath(String ans, int x, int y, HashSet<String> hs, int m, int n) {
//        if (x > m || y > n) return;
//
//        if (x == m && y == n) {
//            hs.add(ans);
//        }
//
//        findPath(ans + x + y, x + 1, y, hs, m, n);
//        findPath(ans + x + y, x, y + 1, hs, m, n);
//    }
}
