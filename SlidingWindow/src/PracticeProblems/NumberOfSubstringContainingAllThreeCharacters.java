package PracticeProblems;

import java.util.HashMap;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {

    }

    public static int numberOfSubstrings(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int j = 0, i = 0, ans = 0, n = s.length();
        while (j < s.length()) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
//            int count=mp.size();
            while (mp.getOrDefault('a', 0) > 0 && mp.getOrDefault('b', 0) > 0 && mp.getOrDefault('c', 0) > 0) {
                ans += n - j;
                char ch2 = s.charAt(i);
                mp.put(ch2, mp.get(ch2) - 1);
                i++;
            }
            j++;
        }
        return ans;
    }
}
