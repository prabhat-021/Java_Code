package Recursion;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String[] wordDist = {"aa","a"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordDist));

//        Collections.reverse(wordList);
        System.out.println(wordBreak(s, wordList));
    }

//    public static boolean wordBreak(String s, List<String> wordDict) {
////        List<String> dp = new ArrayList<>();
//        HashSet<String> dp = new HashSet<>();
//        Set<String> wordSet = new HashSet<>(wordDict);
//        boolean flag = false;
//        return wordBreak(s, wordSet, dp, flag);
//    }
//
//    private static boolean wordBreak(String s, Set<String> wordDict, HashSet<String> dp, boolean flag) {
//        //        BASE CASE
//        if (wordDict.contains(s) || s.length() == 0) return true;
//
//        boolean ans;
//
//        for (int i = 1; i < s.length(); i++) {
//            if (flag) break;
//            String st = s.substring(0, i);
//            if (dp.contains(st) && !wordDict.contains(st)) {
////                dp.remove(st);
//                continue;
//            } else if (wordDict.contains(st)) {
//                dp.add(st);
//                ans = wordBreak(s.substring(i), wordDict, dp, flag);
//                flag = flag || ans;
//            }
//            if (flag) break;
//        }
//        return flag;
//    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<String> memo = new HashSet<>();
        return wordBreak(s, wordSet, memo);
    }

    private static boolean wordBreak(String s, Set<String> wordSet, Set<String> memo) {
        // BASE CASE
        if (s.length() == 0) return true;
        if (memo.contains(s)) return false;

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix)) {
                if (wordBreak(s.substring(i), wordSet, memo)) {
                    return true;
                }
            }
        }

        memo.add(s);
        return false;
    }
}
