package BinarySearch;

public class findTheSmallestDivisor {
    public static void main(String[] args) {

    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }
        int low = 1, high = maxi;
//        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = sumDivisor(nums, mid);
            if (sum <= threshold) {
//                ans = sum;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int sumDivisor(int[] arr, int divisor) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.ceil((double) arr[i] / (double) divisor);
        }
        return ans;
    }
}
