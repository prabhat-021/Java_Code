package DynamicProgrmming.Subsequences;

public class RodCuttingProblem {
    public static void main(String[] args) {

    }

    public int cutRod(int[] price, int N) {
        int n = price.length;

        int[][] dp = new int[n][N + 1];

        return cutRod(price, N, n - 1, dp);
    }

    private int cutRod(int[] price, int length, int idx, int[][] dp) {
        if (idx == 0) return length * price[0];

        if (dp[idx][length] != -1) return dp[idx][length];

        int notTake = cutRod(price, length, idx - 1, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = idx + 1;
        if (rodLength <= length) take = price[idx] + cutRod(price, length - rodLength, idx, dp);

        return dp[idx][length] = Math.max(take, notTake);

    }

}
