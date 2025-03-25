package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        calculate(n, k, ans, ll, 0);
        return ans;
    }

    private void calculate(int n, int k, List<List<Integer>> ans, List<Integer> ll, int idx) {
        if (ll.size() == k) {
            ans.add(new ArrayList<>(ll));
            return;
        }

        for (int i = idx; i <= n; i++) {
            ll.add(i);
            calculate(n, k, ans, ll, i+1);
            ll.remove(ll.size() - 1);
        }
    }
}
