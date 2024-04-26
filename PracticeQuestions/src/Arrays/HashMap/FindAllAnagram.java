package Arrays.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagram {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> mp = new HashMap<>();

        if (s.length() < p.length())
            return new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            mp.put(p.charAt(i), mp.getOrDefault(p.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> duplicate = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            duplicate.put(s.charAt(i), duplicate.getOrDefault(s.charAt(i), 0) + 1);
            if (duplicate.equals(mp)) {
                ans.add(i - p.length() + 1);
            }
            if (i >= p.length() - 1) {
                char ele = s.charAt(i - p.length() + 1);
                duplicate.put(ele, duplicate.get(ele) - 1);

                if (duplicate.get(s.charAt(i - p.length() + 1)) == 0)
                    duplicate.remove(s.charAt(i - p.length() + 1));
            }
        }

        return ans;
    }


//    private static long calculateHash(String str) {
//        long hash = 0;
//        for (int i = 0; i < str.length(); i++) {
//            hash = hash + str.charAt(i);
//        }
//        return hash;
//    }
//
//    private static long updateHash(long prevHash, char oldChar, char newChar) {
//        long newHash = (prevHash - oldChar);
//        newHash = newHash + newChar;
//        return newHash;
//    }
//
//    public List<Integer> findAnagrams(String s, String p) {
//        int patternLength = p.length();
//        long patternHash = calculateHash(p);
//        long textHash = calculateHash(s.substring(0, patternLength));
//        List<Integer> ll = new ArrayList<>();
//
//        for (int i = 0; i <= s.length() - patternLength; i++) {
//            if (textHash == patternHash) {
//                if (areAnagrams(p, s.substring(i, i + patternLength)))
//                    ll.add(i);
//            }
//
//            if (i < s.length() - patternLength) {
//                textHash = updateHash(textHash, s.charAt(i), s.charAt(i + patternLength));
//            }
//        }
//        return ll;
//    }
//
//    public static boolean areAnagrams(String str1, String str2) {
//        char[] charArray1 = str1.toCharArray();
//        char[] charArray2 = str2.toCharArray();
//
//        Arrays.sort(charArray1);
//        Arrays.sort(charArray2);
//
//        return Arrays.equals(charArray1, charArray2);
//    }

//    public int[] singleNumber(int[] nums) {
//        int[] arr = new int[2];
//        arr[0] = nums[0];
//        arr[1] = nums[1];
//        for (int i = 2; i < nums.length; i++) {
//            arr[0]^=nums[i];
//        }
//    }
}
