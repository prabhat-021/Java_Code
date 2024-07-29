package DynamicProgrmming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {

    }

    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(hash, 1);
        Arrays.sort(arr);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] % arr[prev] == 0 && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        return temp;
    }
}
