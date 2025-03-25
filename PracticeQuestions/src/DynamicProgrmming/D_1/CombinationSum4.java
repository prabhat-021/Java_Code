package DynamicProgrmming.D_1;

import java.util.Arrays;

public class CombinationSum4 {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target) {
//        int[] count = new int[1];
        int[] count = new int[target + 1];
        Arrays.fill(count, -1);
        return findCombination(nums, target, count);
    }

    private int findCombination(int[] nums, int target, int[] count) {
        if (target == 0) {
            return 1;
        }

        if (count[target] != -1) return count[target];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += findCombination(nums, target - nums[i], count);
            }
        }

        count[target] = ans;
        return count[target];
    }
}
