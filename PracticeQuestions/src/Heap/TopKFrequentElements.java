package Heap;

import java.security.PublicKey;
import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }
        );

        pq.addAll(mp.entrySet());

        int[] ans = new int[k];
        int i = 0;

        while (!pq.isEmpty() && k > 0) {
            int ele = pq.poll().getKey();
            if (i > 0 && ele == ans[i - 1]) continue;
            else {
                ans[i++] = ele;
                k--;
            }
        }

        return ans;
    }

//    public class Pair {
//        int ele;
//        int freq;
//
//        public void Pair(int ele, int freq) {
//            this.ele = ele;
//            this.freq = freq;
//        }
//    }
}
