package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] v = {30, 11, 23, 4, 20};
        int h = 5;
        int ans = minEatingSpeed(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);
        int low = 0, high = piles[max];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getHour(piles, mid) <= h) high = mid - 1;
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int getHour(int[] arr, int hour) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.ceil((double) arr[i] / (double) hour);
        }
        return ans;
    }

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        ;
        int n = v.length;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
}
