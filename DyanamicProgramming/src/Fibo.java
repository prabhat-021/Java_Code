public class Fibo {
    public static void main(String[] args) {
        int n = 1230;
        long[] dp = new long[n + 1];
        System.out.println(fibTB(n, dp));
        System.out.println();
        System.out.println(fibBU(n));
    }

    public static long fibTB(int n, long[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fibTB(n - 1, dp) + fibTB(n - 2, dp);
    }

    public static long fibBU(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
