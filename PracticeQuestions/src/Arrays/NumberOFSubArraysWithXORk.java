package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberOFSubArraysWithXORk {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subArrayWithSumK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }

    static int subArrayWithSumK(int[] arr, int k) {
        int n = arr.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mp = new HashMap<>(); //declaring the map.
        mp.put(xr, 1); //setting the value of 0.
        int cnt = 0;
        for (int i = 0; i <n; i++) {
            xr = xr ^ arr[i];
            int x = xr ^ k;
            if (mp.containsKey(x)) {
                cnt += mp.get(x);
            }

            if (mp.containsKey(xr)) {
                mp.put(xr, mp.get(xr) + 1);
            } else {
                mp.put(xr, 1);
            }
        }
        return cnt;
    }
}
