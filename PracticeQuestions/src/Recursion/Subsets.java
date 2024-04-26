package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> ll=new ArrayList<>();
        findsubset(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public static void findsubset(List<List<Integer>> ans, List<Integer> ll, int[] arr, int idx) {
//      BASE CASE
        ans.add(new ArrayList<>(ll));
        for (int i = idx; i < arr.length; i++) {
            ll.add(arr[i]);
            findsubset(ans, ll, arr, i + 1);
            ll.remove(ll.size() - 1);
        }
    }
}

