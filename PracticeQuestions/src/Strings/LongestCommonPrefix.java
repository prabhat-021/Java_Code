package Strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) return strs[0];
        String src = strs[0];
        String test = strs[1];
        src = lcp(src, test);

        for (int i = 2; i < strs.length; i++) {
            test = strs[i];
            src = lcp(src, test);
        }

        return src;
    }

    private static String lcp(String s, String t) {
        String ans = "";
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) != t.charAt(j)) return ans;
            if (s.charAt(i) == t.charAt(j)) ans += s.charAt(i);
            i++;
            j++;
        }
        return ans;
    }
}
