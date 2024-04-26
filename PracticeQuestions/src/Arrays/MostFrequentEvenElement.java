package Arrays;

import java.util.HashMap;

public class MostFrequentEvenElement {
    public static void main(String[] args) {

    }

    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
//        int minElement=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                if (mp.containsKey(nums[i])) {
                    mp.put(nums[i], mp.get(nums[i]) + 1);
                } else {
                    mp.put(nums[i], 1);
                }
            }
        }
        if (mp.size() == 0) return -1;
        int maxFreq = 1, anskey = Integer.MAX_VALUE;
        for (var ele : mp.entrySet()) {
            if (ele.getValue() >= maxFreq) {
                if (ele.getValue() == maxFreq) {
                    anskey = Math.min(anskey, ele.getKey());
                } else {
                    maxFreq = ele.getValue();
                    anskey = ele.getKey();
                }

            }
        }
        return anskey;
    }
}
