package BinarySearch;

public class firstAndtheLastOccurence {
    public static void main(String[] args) {

    }

    public static int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        if (nums.length==0 || lb == nums.length || nums[lb] != target ) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums, target);
        return new int[]{lb, ub-1};
    }

    public static int lowerBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
