package Arrays.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {

    }

    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int k : arr) {
            int leftOut = s - k;
            if (mp.containsKey(leftOut)) {
                int count = mp.get(leftOut);
                for (int j = 0; j < count; j++) {
                    int[] pair = new int[2];
                    pair[0] = Math.min(k, leftOut);
                    pair[1] = Math.max(k, leftOut);
                    ans.add(pair);
                }
            }
            mp.put(k, mp.getOrDefault(k, 0) + 1);
        }

        ans.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return ans;
    }
}
