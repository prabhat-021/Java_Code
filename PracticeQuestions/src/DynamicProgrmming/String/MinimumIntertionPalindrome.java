package DynamicProgrmming.String;

import java.util.Arrays;

public class MinimumIntertionPalindrome {
    public static void main(String[] args) {
        String st = "prabhatsehrawat";
        System.out.println(minInsertions(st));
    }

    public static int minInsertions(String s) {
//        StringBuilder st = new StringBuilder(s).reverse();
//        System.out.println(s.length() - longestCommonSubsequence(s, st.toString()));

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s.charAt(i - 1) == s.charAt(n - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return n - dp[n][n];
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return LCS(text1, text2, len1 - 1, len2 - 1, dp);
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
