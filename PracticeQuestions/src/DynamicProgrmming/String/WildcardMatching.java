package DynamicProgrmming.String;

import java.util.Arrays;

public class WildcardMatching {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        int pt = p.length();
        int t = s.length();

        int[][] dp = new int[pt][t];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return isMatch(pt - 1, t - 1, s, p, dp);
    }

    private boolean isMatch(int i, int j, String s, String p, int[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            dp[i][j] = isMatch(i - 1, j - 1, s, p, dp) ? 1 : 0;
        }

        if (p.charAt(i) == '*') {
            dp[i][j] = isMatch(i - 1, j, s, p, dp) || isMatch(i, j - 1, s, p, dp) ? 1 : 0;
        }

        return dp[i][j] == 1;
    }
}
