package Stack.MonotonicStack;

import java.util.Stack;

public class SumSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length;
        int[] nse = findNSE(arr, n);
        int[] pse = findPSE(arr, n);
        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + ((long) (right * left) % mod * arr[i]) % mod) % mod;

        }
        return (int) total;
    }

    public static int[] findNSE(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) st.pop();

            nse[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }


    public static int[] findPSE(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) st.pop();

            pse[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}
