package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class RotateString {
    public static void main(String[] args) {

    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        return s.contains(goal);
//        int idx = findPivt(s, goal);
//        if (idx == -1) return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt((idx + i) % s.length()) != goal.charAt(i)) return false;
//        }
//
//        return true;
    }

//    public int findPivt(String s, String goal) {
//        char ch1 = goal.charAt(0);
//        int ans = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (ch1 == s.charAt(i)) {
//                ans = i;
//                break;
//            }
//        }
//        return ans;
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) - 1);
                if (mp.get(ch) == 0) mp.remove(ch);
            }
        }

        return mp.isEmpty();
    }
}
