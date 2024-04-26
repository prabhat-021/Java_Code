public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }

    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int key, int s, int e) {

        while (s <= e) {

            boolean isAcc = arr[s] < arr[e];

            int mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (isAcc) {
                if (arr[mid] > key) {
                    e = mid - 1;
                } else if (arr[mid] < key) {
                    s = mid + 1;
                }
            } else {
                if (arr[mid] < key) {
                    e = mid - 1;
                } else if (arr[mid] > key) {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
