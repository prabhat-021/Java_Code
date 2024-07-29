package DynamicProgrmming.D_2;

public class CherryPickup {
    public static void main(String[] args) {

    }

    public static int fn(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) return -100000;

        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != 0) return dp[i][j1][j2];
        int maxi = -100000;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int val = 0;

                if (j1 == j2) val = grid[i][j1];
                else val = grid[i][j1] + grid[i][j2];

                val += fn(i, j1 + dj1, j2 + dj2, r, c, grid, dp);
                maxi = Math.max(maxi, val);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}
