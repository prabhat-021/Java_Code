package DynamicProgrmming.Subsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {

    }

    int findWays(int[] nums, int tar) {
        int n = nums.length;

        int[][] dp = new int[n][tar + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] <= tar) dp[0][nums[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int sum = 0; sum <= tar; sum++) {
                int notTake = dp[idx - 1][sum];
                int take = 0;

                if (nums[idx] <= sum) take = dp[idx - 1][sum - nums[idx]];

                dp[idx][sum] = notTake + take;

            }
        }
        return dp[n - 1][tar];
    }
}
