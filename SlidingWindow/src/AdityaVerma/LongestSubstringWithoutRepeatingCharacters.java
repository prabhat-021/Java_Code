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
}
