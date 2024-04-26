package Stack.MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        int[] ans = new int[nums1.length];

        for (int num : nums2) {
            while (!st.empty() && st.peek() < num) {
                mp.put(st.pop(), num);
            }
            st.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = mp.getOrDefault(nums1[i],-1);
        }

        return ans;
    }
}
