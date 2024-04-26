package Arrays;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
//        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
////        List<List<Integer>> ans = merge(arr);
//        System.out.print("The merged intervals are: \n");
//        for (List<Integer> it : ans) {
//            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
//        }
//        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;

//        Sort the Given Interval;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
//            if the current interval does not lie in the last interval;
//
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
//            if the current interval lies in the last interval ;
            else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }
//        return ans.toArray(new int[][])
        return ans.toArray(new int[ans.size()][]);
//
//        // Convert the List of Lists to a 2D array and return it
//        return ans.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

    }
}
