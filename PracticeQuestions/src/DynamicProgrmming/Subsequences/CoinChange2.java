package DynamicProgrmming.Subsequences;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {

    }

//    public int change(int amount, int[] coins) {
//        int n = coins.length;
//
//        int[][] dp = new int[n][amount + 1];
//
//
//
//
//    }

    private int change(int amount, int idx, int[] coins, int[][] dp) {

        if (amount == 0)
            return 1;
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return 1;
            else
                return 0;
        }

        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int notTake = change(amount, idx - 1, coins, dp);
        int take = 0;

        if (coins[idx] <= amount)
            take = change(amount - coins[idx], idx, coins, dp);

        return dp[idx][amount] = take + notTake;
    }
}
