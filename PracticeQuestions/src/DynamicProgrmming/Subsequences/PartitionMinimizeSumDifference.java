package DynamicProgrmming.Subsequences;

public class PartitionMinimizeSumDifference {
    public static void main(String[] args) {

    }
// Only for positive values


    public int minimumDifference(int[] arr) {
        int target = 0, n = arr.length;

        for (int i = 0; i < n; i++) target += arr[i];
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= target) dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= target; k++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (arr[i] <= target) take = dp[i - 1][target - arr[i]];
                dp[i][target] = notTake || take;
            }
        }

        int min1 = 111111;

        for (int i = 0; i <= target; i++) {
            if (dp[n - 1][i]) {
                min1 = Math.min(min1, Math.abs(target - i - i));
            }
        }
        return min1;
    }
}
