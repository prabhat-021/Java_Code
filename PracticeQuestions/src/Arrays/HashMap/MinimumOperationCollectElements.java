package Arrays.HashMap;

import java.util.HashMap;
import java.util.List;

public class MinimumOperationCollectElements {
    public static void main(String[] args) {

    }

    public int minOperations(List<Integer> nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            mp.put(i, 1);
        }
        int operation = 0, j = nums.size() - 1;

        while (mp.size() > 0 && nums.size() > 0) {
            operation++;
            if (mp.containsKey(nums.get(j))) mp.remove(nums.get(j));
            j--;
        }
        return operation;
    }
}
