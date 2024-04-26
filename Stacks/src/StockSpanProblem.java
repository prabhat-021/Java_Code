import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        st.push(0);
        for (int i = 1; i < n ; i++) {
            while (st.size() > 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) res[i] = 1;
            else res[i] = i - st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
