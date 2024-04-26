package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagram {
    public static void main(String[] args) {
        String[] arr = {"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(groupAnagrams(arr));
    }

    public static List<String> groupAnagrams(String[] strs) {
        HashMap<String, Integer> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String sortedWord = new String(arr);
            if (!mp.containsKey(sortedWord)) {
                mp.put(sortedWord, i);
                ans.add(word);
//            mp.get(sortedWord).add(word);
            } else {
                if (mp.get(sortedWord) + 1 == i) {
                    mp.put(sortedWord, i);
                } else {
                    ans.add(word);
                }
            }

        }
//        for (String val: mp.values()) {
//            ans.add((val));
//        }
        return ans;
    }
}
