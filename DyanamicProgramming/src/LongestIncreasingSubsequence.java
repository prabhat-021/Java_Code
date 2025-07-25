import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    }


    public int LIS_Striver(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int maxi=1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if(arr[prev]<arr[i]){
                    dp[i]=Math.max(dp[i],1+dp[prev]);
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }

        return maxi;
    }

    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > dp[len - 1]) {
                dp[len] = arr[i];
                len++;
            } else {
                int idx = Search(dp, 0, len - 1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        return len;
    }

    private static int Search(int[] dp, int si, int ei, int item) {
        int ans = 0;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (dp[mid] >= item) {
                ans = mid;
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
    }

}
