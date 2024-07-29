package DynamicProgrmming.String;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public String PLCS(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int len = LCS(text1, text2, len1 - 1, len2 - 1, dp);

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; i++) {
            ans.append("$");
        }
        int i = len1, j = len2;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.insert(text1.charAt(i - 1), len - 1);
                len--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        return ans.toString();
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
