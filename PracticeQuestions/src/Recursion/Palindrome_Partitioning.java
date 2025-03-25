package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {

    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ll = new ArrayList<>();
        partition(s, ans, ll);
        return ans;
    }

    private void partition(String s, List<List<String>> ans, List<String> ll) {
        if (s.isEmpty()) {
            ans.add(new ArrayList<>(ll));
        }

        for (int i = 1; i <= s.length(); i++) {
            String st = s.substring(0, i);
            ll.add(st);
            if (isPalindrome(st)) partition(s.substring(i), ans, ll);
            ll.remove(ll.size() - 1);
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
