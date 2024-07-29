package Stack.MonotonicStack;

import java.util.Stack;

public class MaximumAreaHistogram {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
            }
            st.push(i);
        }

        while (!st.empty()) {
            int element = st.pop();
            int nse = heights.length;
            int pse = st.empty() ? -1 : st.peek();
            maxArea = Math.max(heights[element] * (nse - pse - 1), maxArea);
        }
        return maxArea;
    }
}
