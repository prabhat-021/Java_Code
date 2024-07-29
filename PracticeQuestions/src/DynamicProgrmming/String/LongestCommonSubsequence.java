package DynamicProgrmming.String;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public int longestCommonSubsequence(String text1, String text2) {
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
