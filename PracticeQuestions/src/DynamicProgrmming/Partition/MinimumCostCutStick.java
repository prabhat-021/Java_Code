package DynamicProgrmming.Partition;

import java.util.Arrays;

public class MinimumCostCutStick {
    public static void main(String[] args) {

    }

    public int minCost(int n, int[] cuts) {
        int[] c = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            c[i + 1] = cuts[i];
        }
        c[c.length - 1] = n;
        Arrays.sort(c);
        int[][] dp = new int[c.length][c.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(c, 1, cuts.length, dp);
    }

    private int solve(int[] cuts, int left, int right, int[][] dp) {
        if (left > right)
            return 0;

        int cost = Integer.MAX_VALUE;

        if (dp[left][right] != -1)
            return dp[left][right];

        for (int i = left; i <= right; i++) {
            int left_cost = solve(cuts, left, i - 1, dp);
            int right_cost = solve(cuts, i + 1, right, dp);

            int curr_cost = (cuts[right + 1] - cuts[left - 1]) + left_cost + right_cost;

            cost = Math.min(curr_cost, cost);
        }

        return dp[left][right] = cost;
    }


    private int solve(int start_stick, int end_stick, int[] cuts, int left, int right) {
        if (left > right) return 0;

        int cost = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            int left_cost = solve(start_stick, cuts[i], cuts, left, i - 1);
            int right_cost = solve(cuts[i], end_stick, cuts, i + 1, right);

            int curr_cost = (end_stick - start_stick) + left_cost + right_cost;

            cost = Math.min(curr_cost, cost);
        }

        return cost;
    }

}
