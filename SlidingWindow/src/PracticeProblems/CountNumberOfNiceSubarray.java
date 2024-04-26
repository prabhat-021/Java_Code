package PracticeProblems;

import java.util.HashMap;

public class CountNumberOfNiceSubarray {
    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }
        return niceArray(nums, k);
    }

    static int niceArray(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prefixSum = 0, count = 0;
        mp.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i] % 2 == 1 ? 1 : 0;
//            mp.put(i,prefixSum);
            if (mp.containsKey(prefixSum - k)) {
                count += mp.get(prefixSum - k);
            }
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

//    public static int numberOfSubarrays(int[] nums, int k) {
//        HashMap<Integer, Integer> mp = new HashMap<>();
//        int i = 0, j = 0, ans = 0;
//        while (j < nums.length) {
//            int ele = nums[j];
//            if (ele % 2 != 0) mp.put(ele, mp.getOrDefault(ele, 0) + 1);
//            int count = mp.size();
//            if (count == k) ans++;
//            else if (count < k) j++;
//            else {
//                while (mp.size() > k) {
//                    int ele2 = nums[i];
//                    mp.put(ele2, mp.get(ele2) - 1);
//                    if (mp.get(ele2) == 0) mp.remove(ele2);
//                    i++;
//                }
//            }
//        }
//        return ans;
//    }

//    public static int numberOfSubarrays(int[] nums, int k) {
//        int count = 0, i = 0, j = 0, ans = 0;
//        while (j < nums.length) {
//            if (nums[j] % 2 != 0) count++;
//            if (count == k) ans = Math.max(ans, j - i + 1);
//            else if (count < k) {
//                j++;
//            } else {
//                while (count > k) {
//                    int ele = nums[i];
//                    if (ele % 2 != 0) count--;
//                    i++;
//                }
//            }
//            j++;
//        }
//        return ans;
//    }


}
