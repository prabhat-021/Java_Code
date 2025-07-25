package BinarySearch;

public class findMinimumInRotatedArray {
    public static void main(String[] args) {

    }

    public int findMin2(int[] arr) {

        int start = 0, n = arr.length;
        int end = n - 1;
        int ans = Integer.MAX_VALUE;
        if (arr[0] < arr[n - 1]) {
            return arr[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                start++;
                end--;
                continue;
            } else {
                if (arr[mid] >= arr[start]) {
                    ans = Math.min(ans, arr[start]);
                    start = mid + 1;
                } else {
                    ans = Math.min(ans, arr[mid]);
                    end = mid - 1;
                }
            }

        }
        return ans;
    }
}
