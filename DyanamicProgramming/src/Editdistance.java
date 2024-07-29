public class Editdistance {
    public static void main(String[] args) {
        System.out.println(editDistance_BU("food","money"));
    }

    public static int editDistance(String s, String t, int i, int j, int[][] dp) {
        if (i == t.length()) {
            return t.length() - j;
        }

        if (j == s.length()) {
            return s.length() - i;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = editDistance(s, t, i + 1, j + 1, dp);
        } else {
            int D = editDistance(s, t, i + 1, j, dp);
            int I = editDistance(s, t, i, j + 1, dp);
            int R = editDistance(s, t, i + 1,j + 1, dp);
            ans = Math.min(I, Math.min(D, R)) + 1;
        }
        return dp[i][j] = ans;
    }

    public static int editDistance_BU(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int ans = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    ans = dp[i - 1][j - 1];
                } else {
                    int D = dp[i - 1][j];
                    int I = dp[i][j - 1];
                    int R = dp[i - 1][j - 1];
                    ans = Math.min(I, Math.min(D, R)) + 1;
                }
                dp[i][j] = ans;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
