package Stack.Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseSubstringParentheses {
    public static void main(String[] args) {

    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ')') {
                while (stack.peek() != '(') {
                    q.add(stack.pop());

                }
                stack.pop();

                while (!q.isEmpty()) {
                    stack.push(q.remove());
                }


            } else {
                stack.push(ch);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();

    }
//
//    public String reverseString(String s) {
//        StringBuilder rs = new StringBuilder(s);
//        return rs.reverse().toString();
//    }
}