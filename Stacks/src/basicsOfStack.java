import java.util.Stack;

public class basicsOfStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        displayRec(st);

        pushAtBottom(st, 7);
        pushAtBottom(st, 70);
        pushAtBottom(st, 700);
        System.out.println(st);

        reverseRecc(st);

        System.out.println(st);
//        Peek --> top
//        System.out.println(st.peek());
//        System.out.println(st);
//        st.pop();
//        System.out.println(st);
//        System.out.println(st.size());
//
//        while(st.size()>1){
//            st.pop();
//        }
//        System.out.println(st.peek());
    }

    public static void displayRec(Stack<Integer> st) {
        if (st.size() == 0) return;
        int top = st.pop();
        System.out.println(top + " ");
        displayRec(st);
        st.push(top);
    }

    public static void pushAtBottom(Stack<Integer> st, int val) {
        if (st.size() == 0) {
            st.push(val);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, val);
        st.push(top);
    }

    public static void reverseRecc(Stack<Integer> st) {
        if (st.size() == 1) {
            return;
        }
        int top = st.pop();
        reverseRecc(st);
        pushAtBottom(st, top);
    }

}