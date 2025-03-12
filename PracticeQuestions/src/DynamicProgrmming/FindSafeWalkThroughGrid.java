package DynamicProgrmming;

import java.util.Arrays;
import java.util.List;

public class FindSafeWalkThroughGrid {
    public static void main(String[] args) {

    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid.get(0).get(0);
                    continue;
                }
                int left = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if (i > 0) left = dp[i - 1][j] + grid.get(i).get(j);
                if (j > 0) up = dp[i][j - 1] + grid.get(i).get(j);

                dp[i][j] = Math.min(left, up);
            }
        }
        return dp[m - 1][n - 1] < health;
    }

//    public int find(List<List<Integer>> grid, int health, int[][] dp, int m, int n, int i, int j) {
//        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) return -100;
//
////        if (dp[i][j] != -100) return dp[i][j];
//
//        find(grid, health, dp, m, n, i - 1, j);
//        find(grid, health, dp, m, n, i, j - 1);
//        find(grid, health, dp, m, n, i + 1, j);
//        find(grid, health, dp, m, n, i, j + 1);
//    }


}
