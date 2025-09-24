package Stack.Practice;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 11000; i > 0; i--) {
            st.push(i + (int) (Math.random() * 10));
        }

        System.out.println("Original stack: " + st);
        sortStack(st);
        System.out.println("Sorted stack: " + st);

    }

    public static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) return;

        int top = st.pop();
        sortStack(st);
        insertStack(st, top);
    }

    public static void insertStack(Stack<Integer> st, int num) {
        if (st.isEmpty() || st.peek() <= num) {
            st.push(num);
            return;
        }

        int top = st.pop();
        insertStack(st, num);
        st.push(top);
    }

}
