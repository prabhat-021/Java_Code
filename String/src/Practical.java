import java.util.Stack;

// Prabhat Sehrawat
//2100290120120
class Customer {
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (st.size() > 0 && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        String ans = "";
        int len = st.size();
        for (int i = 0; i < len; i++) {
            ans = st.pop() + ans;
        }
        return ans;
    }

    public static int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                st.pop();
            } else if (operations[i].equals("D")) {
                st.push(st.peek() * 2);
            } else if (operations[i].equals("+")) {
                int ele1 = st.pop();
                int ele2 = st.peek();
                st.push(ele1);
                st.push(ele1 + ele2);
            } else {
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int len = st.size(), sum = 0;
        for (int i = 0; i < len; i++) {
            sum += st.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String test = "azxxzy";
        System.out.println(removeDuplicates(test));
    }


}