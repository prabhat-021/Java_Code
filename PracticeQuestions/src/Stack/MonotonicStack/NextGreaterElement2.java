package Stack.MonotonicStack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] arr = {1, -3, -1, 0, 2, 3, -3};
        int[] ans = nextGreaterElements(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
//        HashMap<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[nums.length];
//        int[] arr = {1, -3, -1, 0, 2, 3, -3};

        for (int i = 0; i < 2 * nums.length - 1; i++) {
            int k = i % nums.length;
            while (!st.empty() && nums[st.peek()] < nums[k]) {
                int ele = st.pop();
//                mp.put(nums[ele], nums[k]);
                ans[ele] = nums[k];
            }
            if (i < nums.length) st.push(k);
        }
        while (st.size() > 0) {
            ans[st.pop()] = -1;
        }


//        for (int i = 0; i < nums.length; i++) {
//            if (mp.getOrDefault(nums[i], -1) == -1 && (mp.get(nums[i])!=null && mp.get(nums[i])!=-1)) {
//                ans[i] = -1;
//            }
//        }

        return ans;
    }
}
