public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqr";
        String s2 = "aceqrtklfghijklmnopqr";

        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Bottum up");
        System.out.println(lcs_BU(s1, s2));
        System.out.println(lcs_TD(s1, s2, 0, 0, dp));
        System.out.println("Dp above");
        System.out.println(lcs(s1, s2, 0, 0));
    }

    public static int lcs(String s1, String s2, int a, int b) {
        if (a == s1.length() || b == s2.length()) return 0;

        int ans = 0;
        if (s1.charAt(a) == s2.charAt(b)) {
            ans = 1 + lcs(s1, s2, a + 1, b + 1);
        } else {
            int i = lcs(s1, s2, a + 1, b);
            int j = lcs(s1, s2, a, b + 1);
            ans = Math.max(i, j);
        }

        return ans;
    }


    public static int lcs_TD(String s1, String s2, int a, int b, int[][] dp) {
        if (a == s1.length() || b == s2.length()) return 0;

        if (dp[a][b] != -1) return dp[a][b];
        int ans = 0;
        if (s1.charAt(a) == s2.charAt(b)) {
            ans = 1 + lcs(s1, s2, a + 1, b + 1);
        } else {
            int i = lcs(s1, s2, a + 1, b);
            int j = lcs(s1, s2, a, b + 1);
            ans = Math.max(i, j);
        }

        return dp[a][b] = ans;
    }

    public static int lcs_TD_2(String s1, String s2, int a, int b, int[][] dp) {
        if (a < 0 || b < 0) return 0;

        if (dp[a][b] != -1) return dp[a][b];
        int ans = 0;
        if (s1.charAt(a) == s2.charAt(b)) {
            ans = 1 + lcs(s1, s2, a - 1, b - 1);
        } else {
            int i = lcs(s1, s2, a - 1, b);
            int j = lcs(s1, s2, a, b - 1);
            ans = Math.max(i, j);
        }

        return dp[a][b] = ans;
    }

    public static int lcs_BU(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    ans = 1 + dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    ans = Math.max(a, b);
                }
                dp[i][j] = ans;
            }
        }
        return dp[s1.length() - 1][s2.length() - 1];
    }

}
