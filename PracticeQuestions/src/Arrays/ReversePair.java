package Arrays;

public class ReversePair {
    public static void main(String[] args) {

    }

    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
        for (i = 0; i < n1; i++) left[i] = arr[l + i];
        for (j = 0; j < n2; j++) right[j] = arr[mid + 1 + j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    static int mergeSort(int[] arr, int l, int r) {
        int cnt = 0;
        if (l >= r) return cnt;
        int mid = (l + r) / 2;
        cnt += mergeSort(arr, l, mid);
        cnt += mergeSort(arr, mid + 1, r);
        cnt += countPiars(arr, l, mid, r);
        merge(arr, l, mid, r);
        return cnt;
    }

    static int countPiars(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (2 * (long) arr[right])) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
}
