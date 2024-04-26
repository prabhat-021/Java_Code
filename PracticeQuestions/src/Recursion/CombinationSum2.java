package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
//        Arrays.sort(arr);
        print2DList(combinationSum2(arr, target));
    }


    public static void print2DList(List<List<Integer>> list) {
        // Iterate over each row in the 2D List
        for (List<Integer> row : list) {
            // Iterate over each element in the current row
            for (int element : row) {
                // Print the element followed by a space
                System.out.print(element + " ");
            }
            // Print a new line after printing all elements in the row
            System.out.println();
        }
    }

    //  Brute Force
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombination(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    //
//    private static void findcombination(int[] arr, int target, List<List<Integer>> ans, List<Integer> ll, int idx) {
//        if (target == 0) {
//            if (!ans.contains(ll)) {
//                ans.add(new ArrayList<>(ll));
//                return;
//            }
//        }
//
//        for (int i = idx; i < arr.length; i++) {
//            if (target >= arr[i]) {
//                ll.add(arr[i]);
//                findcombination(arr, target - arr[i], ans, ll, i + 1);
//                ll.remove(ll.size() - 1);
//            }
//        }
//    }
    private static void findcombination(int[] arr, int target, List<List<Integer>> ans, List<Integer> ll, int idx) {
        if (target == 0) {
            if (!ans.contains(ll)) {
                ans.add(new ArrayList<>(ll));
                return;
            }
        }

        for (int i = idx; i < arr.length; i++) {
            if (target >= arr[i]) {
                ll.add(arr[i]);
                findcombination(arr, target - arr[i], ans, ll, i + 1);
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }
                ll.remove(ll.size() - 1);
            }
        }
    }

}
