package DynamicProgrmming.D_1;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {

    }

    private static int rob(ArrayList<Integer> arr) {
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = arr.get(i);
            if (i > 1)
                pick += prev2;
            int nonPick = prev;

            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;

        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        if (n == 1) return nums[0];

        for (int i = 0; i < n; i++) {
            if (i != 0) temp1.add(nums[i]);
            if (i != n - 1) temp2.add(nums[i]);
        }

        return Math.max(rob(temp1), rob(temp2));
    }
}
