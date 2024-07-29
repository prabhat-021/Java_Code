package DynamicProgrmming.String;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return count(s, t, n - 1, m - 1, dp);
    }

    public static int count(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = count(s, t, i - 1, j - 1, dp) + count(s, t, i - 1, j, dp);
        } else {
            dp[i][j] = count(s, t, i - 1, j, dp);
        }

        return dp[i][j];
    }

}
