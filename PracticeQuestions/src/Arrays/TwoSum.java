package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSumApproach2(int[] nums, int target) {
        int n = nums.length;
        int[] ans = {-1, -1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int partner = target - nums[i];
            if (mp.containsKey(partner)) {
                return new int[]{i, mp.get(partner)};
            } else {
                mp.put(nums[i], i);
            }
        }
        return ans;
    }

    public int[] twoSumApproach1(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (arr[i] < arr[j]) {
            if ((arr[i] + arr[j]) == target) {
                break;
            } else if ((arr[i] + arr[j]) > target) {
                j--;
            } else {
                i++;
            }
        }
        int cout = 0;
        for (int k = 0; k < arr.length; k++) {
            if (arr[i] == nums[k]) {
                arr[i] = k;
                cout++;
            } else if (arr[j] == nums[k]) {
                arr[j] = k;
                cout++;
            }
            if (cout == 2) {
                break;
            }
        }
        return new int[]{arr[i], arr[j]};
    }
}
