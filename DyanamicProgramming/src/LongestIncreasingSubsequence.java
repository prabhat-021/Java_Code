public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
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
