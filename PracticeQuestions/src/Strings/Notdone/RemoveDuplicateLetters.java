package Strings.Notdone;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {

    }

    public String removeDuplicateLetters(String s) {
        boolean[] arr = new boolean[26];
//        ArrayList<String> ans=new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int chIdx = (int) ch - 97;
//            if (!arr[chIdx] && stack.size() > 0) {
//                if (stack.peek()>ch){
//                    stack.pop();
//                    stack.push(ch);
//                }else {
//                    stack.push(ch);
//                    arr[chIdx]=true;
//                }
//            }
        }

        while (stack.size() > 0) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

//    public static String removeDuplicateLetters(String s) {
//        Stack<Character> st=new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch=s.charAt(i);
//            if(st.size()==0) st.push(ch);
//            if(st.peek()<ch){
//
//            }
//        }
//    }
}
