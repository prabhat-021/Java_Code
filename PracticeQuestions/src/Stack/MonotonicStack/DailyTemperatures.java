package Stack.MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int idx=st.pop();
                ans[idx]=i-idx;
            }
            st.push(i);
        }
        return ans;
    }
}
