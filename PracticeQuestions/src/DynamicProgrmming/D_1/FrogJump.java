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
}
