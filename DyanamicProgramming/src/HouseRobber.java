import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] rob = {2, 9, 7, 3, 1};

        int[] dp = new int[rob.length];
        Arrays.fill(dp, -1);
        System.out.println(rob(rob, 0));
//        System.out.println();
//        System.out.println(rob_TD(rob, 0, dp));
        System.out.println();
        System.out.println(rob_TD_Backward(rob, rob.length - 1, dp));
        System.out.println();
        System.out.println(rob_BU(rob));

    }

//    public int rob(int[] rob) {
//
//    }

    private static int rob(int[] rob, int i) {
        if (i >= rob.length) return 0;

        int rob_T = rob[i] + rob(rob, i + 2);
        int Dn_rob = rob(rob, i + 1);

        return Math.max(rob_T, Dn_rob);
    }

    private static int rob_TD(int[] rob, int i, int[] dp) {
        if (i >= rob.length) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob_T = rob[i] + rob_TD(rob, i + 2, dp);
        int Dn_rob = rob_TD(rob, i + 1, dp);

        return dp[i] = Math.max(rob_T, Dn_rob);
    }

    private static int rob_TD_Backward(int[] rob, int i, int[] dp) {
        if (i < 0) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int rob_T = rob[i] + rob_TD_Backward(rob, i - 2, dp); // dp[i-2]
        int Dn_rob = rob_TD_Backward(rob, i - 1, dp); // dp[i-1]

        return dp[i] = Math.max(rob_T, Dn_rob); // dp[n]=Math.max(dp[i-1],dp[i-2])
    }

    private static int rob_BU(int[] rob) {
        if (1 == rob.length) return rob[0];

        int[] dp = new int[rob.length];
        dp[0] = rob[0];
        dp[1] = Math.max(rob[0], rob[1]);

        for (int i = 2; i < dp.length; i++) {
            int rob_E = rob[i] + dp[i - 2];
            int Dn_rob = dp[i - 1];
            dp[i] = Math.max(rob_E, Dn_rob);
        }

        return dp[dp.length - 1];
    }

}
