package Strings;

import java.util.HashSet;

public class MakeNumberOfDistinctCharactersEquals {
    public static void main(String[] args) {
        String a = "ab";
        String b = "abcc";
        System.out.println(isItPossible(a, b));
    }

    public static boolean isItPossible(String word1, String word2) {
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();

        for (int i = 0; i < word1.length(); i++) {
            hs1.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            hs2.add(word2.charAt(i));
        }

        for (int i = 0; i < 26; i++) {
            char word1Swap = (char) (97 + i);
            if (!hs1.contains(word1Swap)) continue;
            for (int j = 0; j < 26; j++) {
                char word2Swap = (char) (97 + j);
                if (!hs2.contains(word2Swap)) continue;

                HashSet<Character> hs3 = new HashSet<>(hs1);
                HashSet<Character> hs4 = new HashSet<>(hs2);
//                hs3 = hs1;
//                hs4 = hs2;
// Update frequencies
                hs3.add(word2Swap);
                hs3.remove(word1Swap);

                hs4.add(word1Swap);
                hs4.remove(word2Swap);

                if (hs3.size() == hs4.size()) return true;
                // Clean move

                hs3.remove(word2Swap);
                hs3.add(word1Swap);

                hs4.remove(word1Swap);
                hs4.add(word2Swap);
            }
        }
//        int i = 0, j = 0;
//        while (i < word1.length() && j < word2.length()) {
//            hs1.add(word2.charAt(j));
//            hs1.remove(word1.charAt(i));
//
//            hs2.add(word1.charAt(i));
//            hs2.remove(word2.charAt(j));
//
//            if (hs1.size() == hs2.size()) return true;
//        }
//
////        while (i < word1.length()) {
////
////        }
////
////        while (j < word2.length()) {
////
////        }
        return false;
    }
}
