package DynamicProgrmming.D_1;

public class HouseRobber {
    public static void main(String[] args) {

    }

    public static int rob(int[] arr, int[] dp, int i) {
        if (i == 0) return arr[0];
        if (i < 0) return 0;

        if (dp[i] != -1) return dp[i];

        int pick = arr[i] + rob(arr, dp, i - 2);
        int notPick = rob(arr, dp, i - 1);

        return dp[i] = Math.max(pick, notPick);
    }
}
