package Greedy;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

//        int startIdx = BS_Index(intervals, newInterval[0]);
//        int endIdx = BS_Index(intervals, newInterval[1]);

        List<int[]> ll = new ArrayList<>();
        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            ll.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ll.add(newInterval);
        while (i < n) {
            ll.add(intervals[i]);
            i++;
        }

        int[][] array = new int[ll.size()][];
        for (int j = 0; j < ll.size(); j++) {
            array[j] = ll.get(j);
        }
        return array;
    }

//    public int BS_Index(int[][] intervals, int ele) {
//        int start = 0;
//        int end = intervals.length - 1;
//
//        int mid = (start + end) / 2;
//
//        while (mid < end) {
//            mid = (start + end) / 2;
//
//            if (ele >= intervals[mid][0] && ele <= intervals[mid][1]) {
//                return mid;
//            } else if (ele < intervals[mid][0]) {
//                end = mid;
//            } else start = mid + 1;
//        }
//
//        return -1;
//    }

}
