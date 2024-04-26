package Arrays;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
//        majorityElement(nums);
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
//        [element,freq]
//        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxKey = 0;
        for (HashMap.Entry<Integer, Integer> entry : mp.entrySet()) {
            int currentValue = entry.getValue();
            if (currentValue > max) {
                max = currentValue;
                maxKey = (int)entry.getKey();
            }
        }
        if(max>(nums.length)/2) return maxKey;
        return 1;
//        return maxLen;
    }
}
