package DynamicProgrmming.Stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockCoolDown {
    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return maxProfit(0, prices, dp, 1);
    }

    private int maxProfit(int idx, int[] prices, int[][] dp, int buy) {
        if (idx >= prices.length) return 0;

        if (dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[idx] + maxProfit(idx + 1, prices, dp, 0)), maxProfit(idx + 1, prices, dp, 1));
        } else {
            profit = Math.max((prices[idx] + maxProfit(idx + 2, prices, dp, 1)), maxProfit(idx + 1, prices, dp, 0));
        }

        return dp[idx][buy] = profit;
    }
}
