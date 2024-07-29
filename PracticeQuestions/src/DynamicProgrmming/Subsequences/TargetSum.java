package DynamicProgrmming.Subsequences;

public class TargetSum {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        return countPartition(target, nums);
    }

    public int countPartition(int d, int[] arr) {
        int n = arr.length;
        int ttsum = 0;

        for (int i = 0; i < n; i++) {
            ttsum += arr[i];
        }

        if (ttsum - d < 0 || (ttsum-d)%2 == 1 ) return 0;

        return findWays(n, arr, (ttsum - d) / 2);

    }

    int findWays(int n, int[] nums, int tar) {
        int[][] dp = new int[n][tar + 1];

        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= tar) dp[0][nums[0]] = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int target = 0; target <= tar; target++) {
                int notTake = dp[idx - 1][target];
                int take = 0;

                if (nums[idx] <= target) take = dp[idx - 1][target - nums[idx]];

                dp[idx][target] = take + notTake;
            }
        }

        return dp[n - 1][tar];
    }
}
