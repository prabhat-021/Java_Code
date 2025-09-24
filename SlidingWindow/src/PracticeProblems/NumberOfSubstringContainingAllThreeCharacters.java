package PracticeProblems;

import java.util.HashMap;

public class NumberOfSubstringContainingAllThreeCharacters {
    public static void main(String[] args) {

    }

    public static int numberOfSubstrings(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int j = 0, i = 0, ans = 0, n = s.length();
        while (j < n) {
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

    public int numberOfSubstrings_optimal(String s) {
        int[] lastSeen = {-1, -1, -1};
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a']=i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                ans += Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])) + 1;
            }
        }
        return ans;
    }
}
