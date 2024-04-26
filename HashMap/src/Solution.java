import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
//        mp(value,count)
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        int ans = 0;
        for (var e : mp.entrySet()) {
            if (e.getValue() == 1) {
                ans = e.getKey();
            }
        }
        return ans;
    }
}

class Difference {
    public char findTheDifference(String s, String t) {
//        HashSet<Character> hs=new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            hs.add(s.charAt(i));
//        }
//        char ans=t.charAt(0);
//        for (int i = 0; i < t.length(); i++) {
//            if(!hs.contains(t.charAt(i))) {
//                ans=t.charAt(i);
//            }
//        }
//        return ans;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (mp.containsKey(r)) {
                mp.put(r, mp.get(r) + 1);
            } else {
                mp.put(r, 1);
            }
        }
        char ans = t.charAt(0);
        for (int i = 0; i < t.length(); i++) {
            char r = t.charAt(i);

            if (mp.containsKey(r)) {
                if (mp.get(r) == 0) {
                    return ans = r;
                } else {
                    mp.put(r, mp.get(r) - 1);
                }
            } else {
                ans = r;
            }
        }
        return ans;
    }
}