package Strings;

public class ReverseWords {
    public static void main(String[] args) {

    }

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
            } else {
                if (temp.isEmpty()) continue;
                if ((!ans.isEmpty()) && ans.charAt(0) != ' ') {
                    ans.insert(0, ' ');
                }
                ans.insert(0, temp);
                temp = new StringBuilder();
            }
        }
        if (!temp.isEmpty()) {
            if (!ans.isEmpty()) {
                ans.insert(0, temp + " ");
            } else
                ans.insert(0, temp);
        }
        return ans.toString();
    }
}
