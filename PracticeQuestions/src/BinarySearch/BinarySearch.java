package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {

    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (target > mid) {
                return binarySearch(arr, target, mid + 1, end);
            } else if (target < mid) {
                return binarySearch(arr, target, start, mid - 1);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
