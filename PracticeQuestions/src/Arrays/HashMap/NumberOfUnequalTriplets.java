package Arrays.HashMap;

import java.util.HashMap;

public class NumberOfUnequalTriplets {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,4};
        System.out.println(unequalTriplets(arr));
    }

    public static int unequalTriplets(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = 1;
        for (int k = 0; k < nums.length; k++) {
            mp.put(nums[k], mp.getOrDefault(nums[k], 0) + 1);
        }
        int n = nums.length;
        int nCr = n * (n - 1) * (n - 2) / 6;
        for (Integer val : mp.values()) {
            if(val<2) continue;

            int val3=val*(val-1)*(val-2)/6;
            int val2=val*(val-1)*(n-val)/2;
            nCr-=val3+val2;
        }
        return nCr;
    }

}
