package Greedy;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {

    }

    public boolean checkValidString(String s) {
//        Stack<Character> st=new Stack<>();
        int leftX = 0, rightX = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftX++;
                rightX++;
            } else if (ch == ')') {
                leftX--;
                rightX--;
            } else {
                leftX--;
                rightX++;
            }

            if (rightX < 0) return false;
            if (leftX < 0) leftX = 0;
        }

        return leftX == 0;
    }
}
