import java.util.HashMap;
//import java.util.Iterator;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int partner = target - nums[i];
            if (mp.containsKey(partner)) {
                ans = new int[]{i, mp.get(partner)};
                return ans;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}
