package Hashset;

//import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) st.add(num);
        int maxStreek = 0;
        for (int num : st) {
            if (!st.contains(num - 1)) { // num is starting point of a sequence
                int currNum = num;
                int currstreak = 1; // length of current consecutive sequence
                while (st.contains(currNum + 1)) {
                    currstreak++;
                    currNum++;
                }
                maxStreek = Math.max(maxStreek, currstreak);
            }
        }
        return maxStreek;
    }
}
