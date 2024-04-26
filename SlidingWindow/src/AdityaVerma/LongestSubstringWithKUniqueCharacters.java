package AdityaVerma;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {

    }

    public static int kUnique(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (j < s.length()) {
            if (mp.containsKey(s.charAt(j))) {
                mp.put(s.charAt(j), mp.get(s.charAt(j)) + 1);
            } else {
                mp.put(s.charAt(j), 1);
            }
            int count = mp.size();
            if (count == k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (count < k) {
                j++;
            } else {
                while (mp.size() > k) {
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
