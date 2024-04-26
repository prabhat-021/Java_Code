package Arrays.notdone;

import java.util.HashMap;

public class TopKFrequentElements {
    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
//        int minElement=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }

        }
        int[] arr = new int[k];
//        int freq = 0, i = 0;
//        for (var ele : mp.entrySet()) {
//            if (ele.getValue() > freq) {
//                freq= ele.getValue();
//                nums[i++] = ele.getKey();
//                i %= k;
//            }
//        }
        return arr;
    }
}
