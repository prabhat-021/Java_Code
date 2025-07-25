package AdityaVerma;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println("The length of the longest substring without repeating characters is" + allUnique(str));
    }

    public static int allUnique(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            } else {
                mp.put(s.charAt(j), 1);
            }
            int count = mp.size();
            if (count == j - i + 1) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (mp.size() < j - i + 1) {
                while (mp.size() < j - i + 1) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0)return 0;
        if(len==1)return 1;
        HashMap<Character, Integer> mp = new HashMap<>();

        int right = 0, left = 0, maxLen = 0;
        while (right < len) {
            char ch = s.charAt(right);
            if (mp.containsKey(ch)) {
                left = Math.max(mp.get(ch)+1, left);
            }
            mp.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
