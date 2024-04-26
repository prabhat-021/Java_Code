package BinarySearch;

public class NthRootOfAnInteger {
    public static void main(String[] args) {
        int n = 9, m = 1953125;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }

    public static int NthRoot(int n, int m) {
        int low = 0, high = (int) m / (n * n);
        while (low <= high) {
            int mid = (low + high) / 2;
            long ans = multi(mid, n, m);
            if (ans == m) {
                return mid;
            } else if (ans > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static long multi(int val, int times, int maxValue) {
        long ans = 1;
        for (int i = 0; i < times; i++) {
            ans *= val;
            if (ans > maxValue) {
                break;
            }
        }
        return ans;
    }
}
