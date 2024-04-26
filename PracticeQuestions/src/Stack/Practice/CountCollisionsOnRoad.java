package Stack.Practice;

import java.util.Stack;

public class CountCollisionsOnRoad {
    public static void main(String[] args) {
        String arr = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
        System.out.println(countCollisions(arr));
    }

    public static int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        int j = 0, count = 0;
        while (j < directions.length()) {
            char ch = directions.charAt(j);
            if (st.isEmpty()) st.push(ch);
            else if (st.peek() == 'R') {
                if (ch == 'L') {
                    st.pop();
                    count += 2;
                    st.push('S');
                } else if (ch == 'R') st.push(ch);
                else {
                    st.pop();
                    count += 1;
                    st.push(ch);
                }
            } else if (st.peek() == 'S') {
                if (ch == 'L') count += 1;
            }
            char curr=st.pop();
            while (!st.isEmpty() && ((st.peek() == 'R' && curr == 'S'))) {
                count += 1;
                st.pop();
            }
            j++;
        }
        return count;
    }
    private  int countCollisions1(String directions) {
        Stack<Character> st = new Stack<>();
        int j = 1, count = 0;
        if (st.isEmpty()) st.push(directions.charAt(0));
        while (j < directions.length()) {
            char ch = directions.charAt(j);
            if (st.peek() == 'R' && ch == 'L') {
                st.pop();
                count += 2;
                ch='S';
            } else if (st.peek() == 'S' && ch == 'L') {
                count += 1;
                ch='S';
            }
            while (!st.isEmpty() && ((st.peek() == 'R' && ch == 'S'))) {
                count += 1;
                st.pop();
            }
            st.push(ch);
            j++;
        }
        return count;
    }
}
