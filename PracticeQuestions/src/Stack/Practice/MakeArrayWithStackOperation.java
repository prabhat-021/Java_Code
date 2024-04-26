package Stack.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MakeArrayWithStackOperation {
    public static void main(String[] args) {

    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ll = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 1;
        while (i < target.length) {
            st.push(j);
            ll.add("Push");
            if (st.peek() == target[i]) i++;
            else {
                st.pop();
                ll.add("Pop");
            }
            j++;
        }
        return ll;
    }
}
