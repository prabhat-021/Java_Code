package AdityaVerma;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {

    }

    public static int maxSum(int[] arr, int k) {
        int sum = 0, i = 0, j = 0, ans = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) j++;
            if (j - i + 1 == k) {
                ans = Math.max(sum, ans);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }
}
