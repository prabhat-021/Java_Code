public class CoinChange {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int c = 1; c < dp.length; c++) {
            for (int am = 0; am < dp[0].length; am++) {
                int inc = 0;
                int exc;
                if (am >= coins[c - 1]) {
                    inc = dp[c][am - coins[c - 1]];
                }
                exc = dp[c - 1][am];
                dp[c][am] = inc + exc;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
