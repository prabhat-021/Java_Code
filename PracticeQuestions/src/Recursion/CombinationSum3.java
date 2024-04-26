package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(k, n, ans, new ArrayList<>(), 1);
        return ans;
    }

    private static void findCombination(int limit, int target, List<List<Integer>> ans, List<Integer> ll, int start) {
        if (ll.size() == limit && target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = start; i < 10; i++) {
            ll.add(i);
            if (ll.size() <= limit) {
                findCombination(limit, target - i, ans, ll, i + 1);
            }
            ll.remove(ll.size() - 1);
        }
    }
}
