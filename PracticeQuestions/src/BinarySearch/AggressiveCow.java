package BinarySearch;
// (minimum distance between cows ) is maximum

import java.util.Arrays;

public class AggressiveCow {
    public static void main(String[] args) {

    }

    // BRUTE FORCE aPPORCH
    static int aggressiveCow_brute(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        int limit = arr[n - 1];
        for (int i = 1; i < limit; i++) {
            if (canWePlace(arr, i, k)) {
                return (i - 1);
            }

        }
        return limit;
    }


    //    OPTIMAL APPORACH BINARAY SEARCH
    static int aggressiveCows(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1, high = arr[n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWePlace(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    static boolean canWePlace(int[] nums, int distance, int cows) {
        int cntCow = 1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= distance) {
                cntCow++;
                last = nums[i];
            }
            if (cntCow >= cows) return true;
        }
        return false;
    }
}
