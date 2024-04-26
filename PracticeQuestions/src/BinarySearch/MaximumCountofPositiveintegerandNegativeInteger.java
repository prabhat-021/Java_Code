package BinarySearch;

public class MaximumCountofPositiveintegerandNegativeInteger {
    public static void main(String[] args) {

    }
//    public int maximumCount(int[] nums) {
//
//    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1, ans = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
