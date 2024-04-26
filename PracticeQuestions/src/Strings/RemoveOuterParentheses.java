package Strings;

public class RemoveOuterParentheses {
    public static void main(String[] args) {

    }

    public String removeOuterParentheses(String s) {
        int len = s.length();
        if (len <= 2) return "";
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                count++;
                if (count > 1) ans.append('(');
            } else {
                if (count > 1) ans.append(')');
                count--;
            }
        }
        return ans.toString();
    }

}
