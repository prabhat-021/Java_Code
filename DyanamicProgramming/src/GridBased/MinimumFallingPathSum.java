package GridBased;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -100000);
        }

        for (int i = 0; i < arr.length; i++) {
            ans = Math.min(ans, fallingPath(arr, 0, i, dp));
        }

        System.out.println(ans);
    }

    public static int fallingPath(int[][] arr, int cr, int cc, int[][] dp) {
//        if (cr < 0 || cr > arr[0].length || cc < 0 || cc > arr.length) return Integer.MAX_VALUE;
        if (cc >= arr[0].length || cc < 0) return Integer.MAX_VALUE;

        if (cr == arr.length - 1) return arr[cr][cc];

        if (dp[cr][cc] != -100000) return dp[cr][cc];

        int ld = fallingPath(arr, cr + 1, cc - 1, dp);
        int rd = fallingPath(arr, cr + 1, cc + 1, dp);
        int down = fallingPath(arr, cr + 1, cc, dp);

        return dp[cr][cc] = Math.min(ld, Math.min(rd, down)) + arr[cr][cc];
    }
}
