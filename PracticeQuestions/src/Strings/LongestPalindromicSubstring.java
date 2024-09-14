package Strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }


    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length()-1; i++) {
            String odd = check(s, i, i);
            String even = check(s, i, i+1);

            ans = (odd.length() > ans.length()) ? odd : (even.length() > ans.length()) ? even : ans;
        }

        return ans;
    }

    public static String check(String s, int left, int right) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right );
    }
}
