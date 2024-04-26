package Arrays;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 1, 9};
        long k = 10;
        int len = HashMapAproach(a, k);
        System.out.println("The length of the longest subarray is: " + len);

        int len2 = TwoPointerApproach(a, k);
        System.out.println("The length of the longest subarray is: " + len2);
    }
    static int HashMapAproach(int[] arr, long k) {

        HashMap<Long, Integer> mp = new HashMap<>();
        int maxLen = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
//            PrefixSum
            sum += arr[i];

            // if the sum = k, update the maxLen:
            if (k == sum) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of the remaing part

            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (mp.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - mp.get(rem));
            }

            //Finally, update the map checking the conditions:
            if (!mp.containsKey(sum)) {
                mp.put(sum, i);
            }
        }
        return maxLen;
    }

    static int TwoPointerApproach(int[] arr, long k) {
        int maxLen = 0, sum = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length) sum += arr[i];
            while (j <= i && sum > k) {
                sum -= arr[j++];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, i - j + 1);
            }
        }

        return maxLen;
    }
}
