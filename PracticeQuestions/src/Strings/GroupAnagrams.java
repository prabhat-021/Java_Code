package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String sortedWord = new String(arr);
            if (!mp.containsKey(sortedWord)) {
                mp.put(sortedWord, new ArrayList<>());
            }

            mp.get(sortedWord).add(word);
        }
        return new ArrayList<>(mp.values());
    }
}
