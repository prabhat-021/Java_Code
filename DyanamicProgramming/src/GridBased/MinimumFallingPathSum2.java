package GridBased;

import java.util.Arrays;

public class MinimumFallingPathSum2 {
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

        if (cr == arr.length - 1) return arr[cr][cc];

        if (dp[cr][cc] != -100000) return dp[cr][cc];

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            if (cc != i) ans = Math.min(ans, fallingPath(arr, cr+1, i, dp));
        }

        return dp[cr][cc] = ans + arr[cr][cc];
    }
}
