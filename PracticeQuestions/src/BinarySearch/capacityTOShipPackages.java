package BinarySearch;

public class capacityTOShipPackages {
    public static void main(String[] args) {

    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = 1, high = weights.length * 1000;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkCapacity(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean checkCapacity(int[] arr, int limit, int days) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == limit || (sum + arr[i]) > limit) {
                cnt++;
                sum = 0;
            }
            sum += arr[i];
            if (sum > limit) return false;
        }
        cnt++;
        return cnt <= days;
    }
}
