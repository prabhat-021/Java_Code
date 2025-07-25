public class Knapsack01 {
    public static void main(String[] args) {

    }

    public static int maximumValue(int[] wt, int[] val, int cap, int i) {
        if (i == wt.length || cap == 0) return 0;

        int inc = 0;
        int exc;
        if (cap >= wt[i]) {
            inc = val[i] + maximumValue(wt, val, cap - wt[i], i + 1);
        }

        exc = maximumValue(wt, val, cap, i + 1);

        return Math.max(inc, exc);
    }

    public static int maximumValue_M(int[] wt, int[] val, int cap, int i, int[][] dp) {
        if (i == wt.length || cap == 0) return 0;

        if (dp[i][cap] != -1) return dp[i][cap];

        int inc = 0;
        int exc;
        if (cap >= wt[i]) {
            inc = val[i] + maximumValue_M(wt, val, cap - wt[i], i + 1, dp);
        }

        exc = maximumValue_M(wt, val, cap, i + 1, dp);

        return dp[i][cap] = Math.max(inc, exc);
    }

    public static int maximumValue_T(int[] wt, int[] val, int cap) {
        int n = wt.length;
        int[][] dp = new int[n][cap + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= cap; j++) {
                int inc = 0, exc = 0;
                if (j >= wt[i]) {
                    inc = val[i] + dp[i + 1][j - wt[i]];
                }

                exc = dp[i + 1][j];
                dp[i][j] = Math.max(inc, exc);
            }
        }
        return dp[0][cap];
    }

}
