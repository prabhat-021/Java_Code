package BinarySearch;

public class BookAllocation {
    public static void main(String[] args) {

    }

    static int maximumAllocation(int[] pages, int student) {
        if (pages.length < student) return -1;
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < pages.length; i++) {
            if (maxi < pages[i]) {
                maxi = pages[i];
            }
            sum += pages[i];
        }
        int low = maxi, high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int ans = cntStudent(pages, mid);
            if (ans > student) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int cntStudent(int[] arr, int pages) {
        int std = 1, pagesPerStudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesPerStudent + arr[i] <= pages) {
                pagesPerStudent += arr[i];
            } else {
                std++;
                pagesPerStudent = arr[i];
            }
        }
        return std;
    }
}
