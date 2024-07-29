package DynamicProgrmming.Subsequences;

public class SubsetSumEqualsTarget {
    public static void main(String[] args) {

    }

    boolean fn(int idx, int target, int[] arr, boolean[][] dp) {
        if (target == 0) return true;

        if (idx == 0) return arr[0] == target;

        if (dp[idx][target]) return dp[idx][target];

        boolean notTake = fn(idx - 1, target, arr, dp);
        boolean take = false;

        if (arr[idx] <= target) take = fn(idx - 1, target - arr[idx], arr, dp);
        return dp[idx][target] = take || notTake;
    }
}
