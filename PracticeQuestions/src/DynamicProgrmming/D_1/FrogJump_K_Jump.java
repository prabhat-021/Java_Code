package DynamicProgrmming.D_1;

import java.util.Arrays;

public class FrogJump_K_Jump {
    public static void main(String[] args) {

    }

    public static int frogjump_k(int[] arr, int k) {
//        if (idx == 0) return 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int miniStep = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            miniStep = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    miniStep = Math.min(jump, miniStep);
                }
            }
            dp[i] = miniStep;
        }
        return dp[arr.length - 1];
    }
}
