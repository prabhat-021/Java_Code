package Arrays;

public class BestTimeToBuyAndStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        maxProfit(arr);
    }

    public static int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
