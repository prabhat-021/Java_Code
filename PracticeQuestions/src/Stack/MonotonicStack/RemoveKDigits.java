package Stack.MonotonicStack;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10200";
        System.out.println(removeKdigits(num, 1));
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && (st.peek()) > (num.charAt(i) - '0')) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i) - '0');
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.insert(0, st.pop());
        }

        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        if (ans.isEmpty()) return "0";
        return ans.toString();
    }
}
