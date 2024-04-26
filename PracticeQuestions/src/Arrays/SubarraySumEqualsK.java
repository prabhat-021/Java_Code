package Arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1,-1,0};
        subarraySum(arr, 0);
    }

    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxlen = 0, prefixsum = 0;
        mp.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            prefixsum += arr[i];
            if (mp.containsKey(prefixsum-k)) {
                // maxlen = Math.max(maxlen, i - mp.get(prefixsum-k));
                maxlen+=mp.get(prefixsum-k);
            }
            mp.put(prefixsum, mp.getOrDefault(prefixsum,0)+1 );


        }
        return maxlen;
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) return nums[0] == k ? 1 : 0;
//        int count = 0;
//        int j = 0, sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//
//            while (j <= i && sum > k) {
//                sum -= nums[j++];
//            }
//            if (sum == k) {
//                count++;
//            }
//            while (i==nums.length-1 && j< nums.length-1){
//                sum-=nums[j++];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
////        while (j!= nums.length){
////            if (sum == k) {
////                count++;
////            }
////            sum-=nums[j++];
////        }
//        return count;
    }
}
