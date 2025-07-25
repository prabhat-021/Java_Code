package DynamicProgrmming.D_1;

public class FrogJump {
    public static void main(String[] args) {

    }

    public static int frogjump(int[] arr, int idx, int[] dp) {
        if (idx == 0) return 0;
        if (dp[idx] != -1) return dp[idx];

        int left = frogjump(arr, idx - 1, dp) + Math.abs(arr[idx] - arr[idx - 1]);
        int right = Integer.MAX_VALUE;
        if (idx > 1) right = frogjump(arr, idx - 2, dp) + Math.abs(arr[idx] - arr[idx - 2]);

        return dp[idx] = Math.min(left, right);
    }

    public static int frogjump_space(int[] arr, int[] dp) {
        dp[0] = 0;
        for (int idx = 1; idx < arr.length; idx++) {
            int left = dp[idx - 1] + Math.abs(arr[idx] - arr[idx - 1]);
            int right = Integer.MAX_VALUE;
            if (idx > 1) right = dp[idx - 2] + Math.abs(arr[idx] - arr[idx - 2]);

            dp[idx] = Math.min(left, right);
        }
        return dp[arr.length - 1];
    }
}
