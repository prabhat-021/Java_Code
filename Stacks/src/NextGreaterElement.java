import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 1, 2, 6, 3, 4};
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        st.push(arr[n - 1]);
        res[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
