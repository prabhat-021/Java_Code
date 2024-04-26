package PracticeProblems;

import java.util.HashMap;

public class SubarrayWithKDifferentInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4};
        int k = 3;
        System.out.println(subarraysWithKDistinct(arr, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 0, i = 0, j = 0;
        while (j < nums.length) {
            int ele = nums[j];
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
            int size = mp.size();
            if (size == k) {
                count++;
                j++;
            } else if (size < k) {
                j++;
            } else {
                mp.remove(nums[j]);
                while (mp.size() == k) {
                    int ele2 = nums[i];
                    mp.put(ele2, mp.get(ele2) - 1);
                    if (mp.get(ele) == 0) mp.remove(ele2);
                    i++;
                    count++;
                }
//                while (i < j) {
//                    count++;
//                    i++;
//                }
                j++;
            }
        }
        return count;
    }
}
