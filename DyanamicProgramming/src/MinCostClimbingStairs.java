import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] dp = new int[arr.length];

        Arrays.fill(dp, -1);
        int zero = Min_Cost(arr, 0, dp);
        int one = Min_Cost(arr, 1, dp);
        System.out.println(Math.min(one, zero));
    }

    public static int Min_Cost(int[] arr, int i, int[] dp) {
        if (i >= arr.length) return 0;

        if (dp[i] != -1) return dp[i];

        int first = Min_Cost(arr, i + 1, dp);
        int sec = Min_Cost(arr, i + 2, dp);

        return dp[i] = Math.min(first, sec) + arr[i];
    }

    public static int Min_Cost_BU(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + arr[i];
        }

        return Math.min(dp[arr.length - 1], dp[arr.length - 2]);
    }
}
