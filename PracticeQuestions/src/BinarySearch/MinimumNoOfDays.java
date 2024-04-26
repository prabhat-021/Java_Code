package BinarySearch;

public class MinimumNoOfDays {
    public static void main(String[] args) {
        int[] arr = {62,75,98,63,47,65,51,87,22,27,73,92,76,44,13,90,100,85};
        int k = 7;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }


    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) return -1;
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini, high = maxi;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0, noOfB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) cnt++;
            else {
                noOfB += cnt / k;
                cnt = 0;
            }
        }
        noOfB += cnt / k;
        return (noOfB >= m);
    }
}
