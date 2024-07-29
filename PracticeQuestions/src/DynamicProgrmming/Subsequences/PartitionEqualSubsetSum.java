package DynamicProgrmming.Subsequences;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;
        sum /= 2;

        int dp[][] = new int[n][sum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return fn(n - 1, sum, nums, dp);
    }

    boolean fn(int idx, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;

        if (idx == 0) return arr[0] == target;

        if (dp[idx][target] != -1) return dp[idx][target] != 0;

        boolean notTake = fn(idx - 1, target, arr, dp);
        boolean take = false;

        if (arr[idx] <= target) take = fn(idx - 1, target - arr[idx], arr, dp);
        dp[idx][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
}
