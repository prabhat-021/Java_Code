package AdityaVerma;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {

    }

    public static int kUnique(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            int count = mp.size();
            if (count == k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (count < k) {
                j++;
            } else {
                while (mp.size() > k) {
                    char rem = s.charAt(i);
                    mp.put(rem, mp.get(rem) - 1);
                    if (mp.get(rem) == 0) mp.remove(rem);
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
}
