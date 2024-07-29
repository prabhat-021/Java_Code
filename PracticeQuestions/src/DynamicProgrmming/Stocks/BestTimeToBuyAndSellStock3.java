package DynamicProgrmming.Stocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];

//
//        for (int[][] arr : dp) {
//            for (int[] arr1 : arr) {
//                Arrays.fill(arr1, -1);
//            }
//        }

//        return maxProfit(0, prices, dp, 1, 2);


//        NO NEED FOR BASE CASE AS IT ALREADY ZERO;
//
//        for (int i = 0; i < n; i++) {
//            for (int buy = 0; buy <= 1; buy++) {
//                dp[i][buy][0] = 0;
//            }
//        }
//
//        for (int buy = 0; buy <= 1; buy++) {
//            for (int cap = 0; cap <= 2; cap++) {
//                dp[n - 1][buy][cap] = 0;
//            }
//        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max((-prices[idx] + dp[idx + 1][0][cap]), dp[idx + 1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max((prices[idx] + dp[idx + 1][1][cap - 1]), dp[idx + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    private int maxProfit(int idx, int[] prices, int[][][] dp, int buy, int cap) {

        if (cap == 0 || idx == prices.length) return 0;

        if (dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[idx] + maxProfit(idx + 1, prices, dp, 0, cap)), maxProfit(idx + 1, prices, dp, 1, cap));
        } else {
            profit = Math.max((prices[idx] + maxProfit(idx + 1, prices, dp, 1, cap - 1)), maxProfit(idx + 1, prices, dp, 0, cap));
        }

        return dp[idx][buy][cap] = profit;
    }
}
