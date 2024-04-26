package Arrays.HashMap;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        int i = 0, j = s1.length();
        while (j < s2.length()) {
            if (Arrays.equals(arr1, arr2)) return true;
            arr2[s2.charAt(i) - 'a']--;
            arr2[s2.charAt(j) - 'a']++;

            i++;
            j++;
        }

        return false;
    }
}
