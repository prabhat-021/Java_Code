import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {

    }

}

class ValidAnagram_Apporach2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> mp = ValidAnagram_Apporach1.makeFreqMap(s);
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (!mp.containsKey(ch)) return false;
            int currFreq = mp.get(ch);
            mp.put(ch, currFreq - 1);
        }
//        All values in map should be 0
        for (Integer i : mp.values()) {
            if (i != 0) return false;
        }
        return true;
    }
}

class ValidAnagram_Apporach1 {
    static HashMap<Character, Integer> makeFreqMap(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (!mp.containsKey(ch)) {
                mp.put(ch, 1);
            } else {
                int currFreq = mp.get(ch);
                mp.put(ch, currFreq + 1);
            }
        }
        return mp;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> mp1 = makeFreqMap(s);
        HashMap<Character, Integer> mp2 = makeFreqMap(t);
        return mp1.equals(mp2);
    }

}

