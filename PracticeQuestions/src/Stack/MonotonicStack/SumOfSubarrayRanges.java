package Stack.MonotonicStack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {

    }
// BRUTE FORCE
//
//    public long subArrayRanges(int[] nums) {
//        long ans=0;
//        for (int i = 0; i < nums.length; i++) {
//            int max=nums[i],min= nums[i];
//            for (int j = i; j < nums.length; j++) {
//                max=Math.max(max,nums[j]);
//                min=Math.min(min,nums[j]);
//                ans+=max-min;
//            }
//        }
//        return ans;
//    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public static long sumSubarrayMaxs(int[] arr) {
//        int mod = (int) 1e9 + 7;
        int n = arr.length;
        int[] nse = findNGE(arr, n);
        int[] pse = findPGE(arr, n);
        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + ((long) right * left) * arr[i]);

        }
        return total;
    }

    public static int[] findNGE(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] <= arr[i]) st.pop();

            nse[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }


    public static int[] findPGE(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] < arr[i]) st.pop();

            pse[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public static long sumSubarrayMins(int[] arr) {
//        int mod = (int) 1e9 + 7;
        int n = arr.length;
        int[] nse = findNSE(arr, n);
        int[] pse = findPSE(arr, n);
        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + ((long) ((long) right * left) * arr[i]));

        }
        return total;
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
