package Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    public static int firstMissing(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) arr[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (idx < n) {
                arr[idx] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
