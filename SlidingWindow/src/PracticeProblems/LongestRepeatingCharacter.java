package PracticeProblems;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {

    }
// leetcode 2024 same answer ; but prefer doing by array more easyer;
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int ans = 0, left = 0, maxRepeat = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            maxRepeat = Math.max(maxRepeat, mp.get(ch));

            if (i - left + 1 - maxRepeat > k) {
                char rem = s.charAt(left);
                mp.put(rem, mp.get(rem) - 1);
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
