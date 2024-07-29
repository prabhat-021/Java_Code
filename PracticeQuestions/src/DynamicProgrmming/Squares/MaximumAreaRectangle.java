package DynamicProgrmming.Squares;

import java.util.Stack;

public class MaximumAreaRectangle {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] hieghts = new int[m];

        for (char[] chars : matrix) {
            for (int j = 0; j < m; j++) {
                if (chars[j] == '1') hieghts[j]++;
                else hieghts[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(hieghts));
        }

        return maxArea;
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
