package PracticeProblems;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static void main(String[] args) {

    }

    public static int totalFruit(int[] fruits) {
//        EDge Case
        if (fruits.length == 1) return 1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 0, j = 0, i = 0;
        while (j < fruits.length) {

//            count= mp.size();
            int fr = fruits[j];
            mp.put(fr, mp.getOrDefault(fr, 0) + 1);
//                j++;
            int count = mp.size();

            if (count == 2) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (count < 2) {
                j++;
            } else {
                while (mp.size() > 2) {
                    int rem = fruits[i];
                    mp.put(rem, mp.get(rem) - 1);
                    if (mp.get(rem) == 0) mp.remove(rem);
                    i++;
                }
                j++;
            }

//            j++;
        }
        return ans;
    }
}
