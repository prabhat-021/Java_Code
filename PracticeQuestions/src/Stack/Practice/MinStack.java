package Stack.Practice;

import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack2 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<>();

    public void push(int ele) {
        if (st.isEmpty()) {
            min = ele;
            st.push(ele);
        } else {
            if (ele > min) st.push(ele);
            else {
                st.push(2 * ele - min);
                min = ele;
            }
        }
    }

    public void pop() {
        if (st.empty()) System.out.println("Empty");
        int n = st.peek();
        st.pop();
        if (n < min) {
            min = 2 * min - n;
        }
    }
}
