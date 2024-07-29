package DynamicProgrmming.Subsequences;

public class CoinChange {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = 100000000;
        }

        for (int idx = 1; idx < n; idx++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[idx - 1][T];
                int take = Integer.MAX_VALUE;
                if (coins[idx] <= T) {
                    take = 1 + dp[idx][T - coins[idx]];
                }

                dp[idx][T] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];
        if (ans >= 100000000) return -1;
        return ans;
    }
}
