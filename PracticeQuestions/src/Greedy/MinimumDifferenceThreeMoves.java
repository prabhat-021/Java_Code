package Greedy;

import java.util.Arrays;

public class MinimumDifferenceThreeMoves {
    public static void main(String[] args) {

    }

    public int minDifference(int[] nums) {
        int len = nums.length - 1;
        if (len <= 3) return 0;

        Arrays.sort(nums);
//        95 82 81 75 20
//        6 6 6 4 1 1 0
//        14 10 5 1 0
//         5 4 3 2
        int ans = nums[len - 1] - nums[0];
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < i + 1; j++) {
                ans = Math.min(ans, nums[len - j] - nums[i - j]);
            }
        }
        return ans;
    }
}
