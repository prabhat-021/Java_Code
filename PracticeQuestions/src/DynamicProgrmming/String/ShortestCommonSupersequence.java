package DynamicProgrmming.String;

import java.util.Arrays;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {

    }

    public String shortestCommonSupersequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        StringBuilder ans = new StringBuilder();

        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(s.charAt(i - 1));
                i--;
            } else {
                ans.append(t.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            ans.append(s.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(t.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }

    private static int LCS(String text1, String text2, int idx1, int idx2, int[][] dp) {
        if (idx2 < 0 || idx1 < 0) return 0;

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + LCS(text1, text2, idx1 - 1, idx2 - 1, dp);
        } else {
            dp[idx1][idx2] = Math.max(LCS(text1, text2, idx1 - 1, idx2, dp), LCS(text1, text2, idx1, idx2 - 1, dp));
        }

        return dp[idx1][idx2];
    }
}
