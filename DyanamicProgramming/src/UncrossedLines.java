public class UncrossedLines {
    public static void main(String[] args) {

    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                int ans = 0;
                if (dp[i][j] != -1) return dp[i][j];

                if (nums1[i - 1] == nums2[j - 1]) {
                    ans = 1 + dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    ans = Math.max(a, b);
                }
                dp[i][j] = ans;
            }
        }
        return dp[nums1.length - 1][nums2.length];
    }
}
