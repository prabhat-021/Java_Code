package DynamicProgrmming.LIS;

import java.util.Arrays;

public class NumberLIS {
    public static void main(String[] args) {

    }

    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                }else if(arr[prev] < arr[i] && dp[i] == 1 + dp[prev]){
                    count[i] += count[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        int nos = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) nos += count[i];
        }

        return nos;
    }

}
